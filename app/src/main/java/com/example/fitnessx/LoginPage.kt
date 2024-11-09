package com.example.fitnessx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val textView7 = findViewById<TextView>(R.id.textView7)
        textView7.setOnClickListener{
            val intent = Intent(this,RegisterPage1::class.java)
            startActivity(intent)
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            val intent = Intent(this,SuccessRegistartion::class.java)
            startActivity(intent)
        }

    }
}