package com.ege.examples.example_templates.data_from_fragment_to_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.R

class DataTransferFtoAActivity : AppCompatActivity() {

    lateinit var name : TextView
    lateinit var email : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datatransferftoa)

        name = findViewById(R.id.textViewName3)
        email = findViewById(R.id.textViewEmail3)

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()
        val myFragment = MyFragment()

        ft.add(R.id.frame, myFragment)

        ft.commit()

    }


    fun takeData(userName : String, userEmail : String){

        name.text = userName
        email.text = userEmail

    }


}