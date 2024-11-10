package com.example.fitnessx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BMICalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bmicalculator)
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

        val weightEditText = findViewById<EditText>(R.id.editTextText)
        val heightEditText = findViewById<EditText>(R.id.editTextText1)

        val calculateButton = findViewById<Button>(R.id.button6)

        calculateButton.setOnClickListener {
            val weight = weightEditText.text.toString().toFloatOrNull()
            val height = heightEditText.text.toString().toFloatOrNull()

            if (weight != null && height != null && height > 0) {
                val bmi = weight / (height * height)

                val resultTextView = findViewById<TextView>(R.id.textView21)
                resultTextView.text = "Your BMI is %.2f".format(bmi)

                val resultweight = findViewById<TextView>(R.id.textView22)
                if (bmi <= 18.5){
                    resultweight.text = "Under Weight"
                }
                else if(bmi > 18.5 && bmi < 25){
                    resultweight.text = "Normal Weight"
                }
                else if(bmi >= 25 && bmi < 30){
                    resultweight.text = "Over Weight"
                }
                else{
                    resultweight.text = "Obese"
                }
            } else {
                Toast.makeText(this,"Enter Valid details",Toast.LENGTH_SHORT).show()
            }
        }

    }
}