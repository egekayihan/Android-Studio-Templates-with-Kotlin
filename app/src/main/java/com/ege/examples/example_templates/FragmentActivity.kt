package com.ege.examples.example_templates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.example_templates.fragment.FirstFragment
import com.ege.examples.R
import com.ege.examples.example_templates.fragment.SecondFragment

class FragmentActivity : AppCompatActivity() {

    lateinit var replace : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        replace = findViewById(R.id.buttonReplace)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val firstFragment = FirstFragment()

        fragmentTransaction.add(R.id.frame, firstFragment)

        fragmentTransaction.commit()

        replace.setOnClickListener {

            val secondFragmentManager : FragmentManager = supportFragmentManager
            val secondFragmentTransaction : FragmentTransaction = secondFragmentManager.beginTransaction()

            val secondFragment = SecondFragment()

            secondFragmentTransaction.replace(R.id.frame, secondFragment)

            secondFragmentTransaction.addToBackStack(null)

            secondFragmentTransaction.commit()

        }

    }


}