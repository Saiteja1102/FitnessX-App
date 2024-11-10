package com.example.fitnessx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val button4 = findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            val intent = Intent(this,BMICalculator::class.java)
            startActivity(intent)
        }

        val imageView14 = findViewById<ImageView>(R.id.imageView14)
        imageView14.setOnClickListener{
            val intent = Intent(this,Chatbot::class.java)
            startActivity(intent)
        }
        val imageView13 = findViewById<ImageView>(R.id.imageView13)
        imageView13.setOnClickListener{
            val intent = Intent(this,Profile::class.java)
            startActivity(intent)
        }
    }
}