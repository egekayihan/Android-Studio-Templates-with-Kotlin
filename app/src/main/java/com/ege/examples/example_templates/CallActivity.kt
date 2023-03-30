package com.ege.examples.example_templates

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.ege.examples.R

class CallActivity : AppCompatActivity() {

    lateinit var phone : EditText
    lateinit var call : Button

    var userNumber : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)

        phone = findViewById(R.id.editTextPhone3)
        call = findViewById(R.id.buttonCall)

        call.setOnClickListener {

            userNumber = phone.text.toString()

            startCall(userNumber)

        }

    }

    fun startCall(userNumber : String){

        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 100)

        else {

            //val intent = Intent(Intent.ACTION_CALL)
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$userNumber")
            startActivity(intent)

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 100 && grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$userNumber")
            startActivity(intent)

        }

    }

}