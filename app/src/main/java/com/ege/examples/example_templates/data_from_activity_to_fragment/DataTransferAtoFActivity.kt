package com.ege.examples.example_templates.data_from_activity_to_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.R
import com.ege.examples.example_templates.data_from_activity_to_fragment.BMIFragment

class DataTransferAtoFActivity : AppCompatActivity() {

    lateinit var etWeight : EditText
    lateinit var etHeight : EditText
    lateinit var calculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datatransferatof)

        etWeight = findViewById(R.id.editTextWeight)
        etHeight = findViewById(R.id.editTextHeight)
        calculate = findViewById(R.id.buttonCalculate)

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()

        val bmiFragment = BMIFragment()

        calculate.setOnClickListener {

            val weight = etWeight.text.toString().toInt()
            val height = etHeight.text.toString().toInt()

            val bundle = Bundle()
            bundle.putInt("weight", weight)
            bundle.putInt("height", height)

            bmiFragment.arguments = bundle

            ft.add(R.id.frame, bmiFragment)

            ft.commit()

        }


    }

}