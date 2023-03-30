package com.ege.examples.example_templates.data_from_fragment_to_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.R
import com.ege.examples.example_templates.data_from_fragment_to_fragment.FirstFragment

class DataTransferFtoFActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datatransferftof)

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        val firstFragment = FirstFragment()

        ft.add(R.id.frame, firstFragment)
        ft.commit()

    }


}