package com.ege.examples.example_templates

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.ege.examples.R

class SharedPrefActivity : AppCompatActivity() {

    lateinit var username : EditText
    lateinit var usermessage : EditText
    lateinit var counter : Button
    lateinit var remember : CheckBox

    var count = 0

    var name : String? = null
    var message : String? = null
    var isChecked : Boolean? = null

    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharedpref)

        username = findViewById(R.id.editTextUsername)
        usermessage = findViewById(R.id.editTextMessage2)
        counter = findViewById(R.id.button)
        remember = findViewById(R.id.checkBox)

        counter.setOnClickListener {
            count++
            counter.setText("" + count)
        }

    }

    override fun onPause() {
        super.onPause()

        saveData()
    }

    fun saveData(){
        sharedPref = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        name = username.text.toString()
        message = usermessage.text.toString()
        isChecked = remember.isChecked


        val editor = sharedPref.edit()

        editor.putString("key name", name)
        editor.putString("key message", message)
        editor.putInt("key count", count)
        editor.putBoolean("key remember", isChecked!!)

        editor.apply()

        Toast.makeText(applicationContext, "Your data is saved", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()

        retrieveData()
    }

    fun retrieveData(){
        sharedPref = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)

        name = sharedPref.getString("key name", null)
        message = sharedPref.getString("key message", null)
        count = sharedPref.getInt("key count", 0)
        isChecked = sharedPref.getBoolean("key remember", false)

        username.setText(name)
        usermessage.setText(message)
        counter.setText("" + count)
        remember.isChecked = isChecked!!
    }

}