package com.ege.examples.example_templates.data_from_activity_to_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ege.examples.R

class SecondActivity : AppCompatActivity() {

    lateinit var tvName : TextView
    lateinit var tvEmail : TextView
    lateinit var tvPhone : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second3)

        tvName = findViewById(R.id.textViewName2)
        tvEmail = findViewById(R.id.textViewEmail2)
        tvPhone = findViewById(R.id.textViewPhone2)

        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getLongExtra("phone", 0)

        tvName.text = "Hello $name"
        tvEmail.text = "Your email address is $email"
        tvPhone.text = "Your phone number is $phone"

    }
}