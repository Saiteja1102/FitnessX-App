package com.example.fitnessx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*

class RegisterPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_page1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val button2 = findViewById<Button>(R.id.button2)
        button2.isEnabled = false
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if(checkBox.isChecked){
                button2.isEnabled = true
            }
            else{
                button2.isEnabled = false
                Toast.makeText(this, "Please read terms and conditions", Toast.LENGTH_SHORT).show()
            }
        }
        val textView7 = findViewById<TextView>(R.id.textView7)
        textView7.setOnClickListener{
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }

    }
}