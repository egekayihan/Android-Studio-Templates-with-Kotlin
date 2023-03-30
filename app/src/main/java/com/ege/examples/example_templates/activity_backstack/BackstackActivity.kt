package com.ege.examples.example_templates.activity_backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ege.examples.R
import com.ege.examples.example_templates.activity_backstack.SecondActivity

class BackstackActivity : AppCompatActivity() {

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.buttonActivity)

        button.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()

        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
    }





}