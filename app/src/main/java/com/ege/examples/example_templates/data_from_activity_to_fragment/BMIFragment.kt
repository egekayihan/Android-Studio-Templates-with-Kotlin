package com.ege.examples.example_templates.data_from_activity_to_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ege.examples.R

class BMIFragment : Fragment() {

    lateinit var result : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_b_m_i, container, false)

        result = view.findViewById(R.id.textViewBMIResult)

        val weight = arguments?.getInt("weight")!!.toInt()
        val height = arguments?.getInt("height")!!.toInt()

        val bmi : Double = ((weight * 10000) / (height * height)).toDouble()

        result.text = "Your BMI is $bmi"

        // Inflate the layout for this fragment
        return view
    }

}