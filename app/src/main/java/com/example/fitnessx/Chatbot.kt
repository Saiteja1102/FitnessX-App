package com.example.fitnessx

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Chatbot : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var welcomeTextView: TextView
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: ImageButton
    private val messageList = mutableListOf<Message>()
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatbot)

        recyclerView = findViewById(R.id.recyler_view)
        welcomeTextView = findViewById(R.id.welcome_text)
        messageEditText = findViewById(R.id.message_edit_text)
        sendButton = findViewById(R.id.send_btn)

        // Setup recycler view
        messageAdapter = MessageAdapter(messageList)
        recyclerView.adapter = messageAdapter
        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true
        recyclerView.layoutManager = llm

        sendButton.setOnClickListener {
            val question = messageEditText.text.toString().trim()
            addToChat(question, Message.SENT_BY_ME)
            messageEditText.setText("")
            callGeminiAPI(question)
            welcomeTextView.visibility = View.GONE
        }
    }

    private fun addToChat(message: String, sentBy: String) {
        runOnUiThread {
            messageList.add(Message(message, sentBy))
            messageAdapter.notifyDataSetChanged()
            recyclerView.smoothScrollToPosition(messageAdapter.itemCount)
        }
    }

    private fun addResponse(response: String) {
        if (messageList.isNotEmpty()) {
            messageList.removeAt(messageList.size - 1) // Remove the "Typing..." message
        }
        addToChat(response, Message.SENT_BY_BOT)
    }

    private fun callGeminiAPI(question: String) {
        // Add "Typing..." message to indicate processing
        addToChat("Typing...", Message.SENT_BY_BOT)

        val generativeModel = GenerativeModel(
            modelName = "gemini-1.5-flash", // Replace with your desired model
            apiKey = "AIzaSyAPqfp5dR7Mi_KHarUYbHlmEBL6tRkpOa8" // Replace with your API key
        )

        val prompt = question
        MainScope().launch {
            try {
                val response = generativeModel.generateContent(prompt)
                response.text?.let { addResponse(it) }
            } catch (e: Exception) {
                // Handle errors appropriately, e.g., show an error message
                addResponse("An error occurred: ${e.message}")
            }
        }
    }
}