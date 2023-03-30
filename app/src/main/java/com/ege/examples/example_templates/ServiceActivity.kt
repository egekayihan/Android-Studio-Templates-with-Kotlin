package com.ege.examples.example_templates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ege.examples.R
import com.ege.examples.example_templates.service_examples.ClassicServiceExample
import com.ege.examples.example_templates.service_examples.JobIntentServiceExample

class ServiceActivity : AppCompatActivity() {

    lateinit var buttonStartService : Button
    lateinit var buttonStartJobService : Button
    lateinit var buttonStopService : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        buttonStartService = findViewById(R.id.buttonStartService)
        buttonStartJobService = findViewById(R.id.buttonStartJobService)
        buttonStopService = findViewById(R.id.buttonStopService)

        buttonStartService.setOnClickListener {

            val intent = Intent(this@ServiceActivity, ClassicServiceExample::class.java)
            startService(intent)

        }

        buttonStartJobService.setOnClickListener {

            val intent = Intent(this@ServiceActivity, JobIntentServiceExample::class.java)
            JobIntentServiceExample.myBackgroundService(this@ServiceActivity, intent)
        }

        buttonStopService.setOnClickListener {

            val intent = Intent(this@ServiceActivity, ClassicServiceExample::class.java)
            stopService(intent)
        }

    }
}