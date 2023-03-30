package com.ege.examples.example_templates.list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second2)

        val position = intent.getIntExtra("position", 0)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val secondFragment = SecondFragment()

        val bundle = Bundle()
        bundle.putInt("position", position)
        secondFragment.arguments = bundle

        fragmentTransaction.add(R.id.frameLayout, secondFragment)

        fragmentTransaction.commit()
    }
}