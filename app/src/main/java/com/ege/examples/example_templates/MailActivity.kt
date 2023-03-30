package com.ege.examples.example_templates

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ege.examples.databinding.ActivityMailBinding

class MailActivity : AppCompatActivity() {

    lateinit var mainBinding : ActivityMailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainBinding = ActivityMailBinding.inflate(layoutInflater)
        val view = mainBinding.root

        setContentView(view)


        mainBinding.buttonSend4!!.setOnClickListener {

            val userAddress = mainBinding.editTextAddress!!.text.toString()
            val userSubject = mainBinding.editTextSubject!!.text.toString()
            val userMessage = mainBinding.editTextMessage!!.text.toString()

            sendEmail(userAddress, userSubject, userMessage)

        }

    }


    fun sendEmail(userAddress : String, userSubject : String, userMessage : String){

        val emailAddresses = arrayOf(userAddress)

        //for only mail

        //val emailIntent = Intent(Intent.ACTION_SENDTO)
        //emailIntent.data = Uri.parse("mailto:")

        //for mail and other communication services

        val emailIntent = Intent(Intent.ACTION_SEND)
        emailIntent.type = "*/*"

        emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddresses)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, userSubject)
        emailIntent.putExtra(Intent.EXTRA_TEXT, userMessage)

        if(emailIntent.resolveActivity(packageManager) != null)
            startActivity(Intent.createChooser(emailIntent, "Choose an app"))

    }


}