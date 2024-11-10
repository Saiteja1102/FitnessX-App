package com.example.fitnessx

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView11 = findViewById<ImageView>(R.id.imageView11)
        imageView11.setOnClickListener{
            val intent = Intent(this,HomePage::class.java)
            startActivity(intent)
        }

        val imageView14 = findViewById<ImageView>(R.id.imageView14)
        imageView14.setOnClickListener{
            val intent = Intent(this,Chatbot::class.java)
            startActivity(intent)
        }
    }
}