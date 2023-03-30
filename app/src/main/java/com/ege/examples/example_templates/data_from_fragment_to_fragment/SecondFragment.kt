package com.ege.examples.example_templates.data_from_fragment_to_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ege.examples.R

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_second3, container, false)

        val name : TextView = view.findViewById(R.id.textViewName4)

        name.text = arguments?.getString("username").toString()

        // Inflate the layout for this fragment
        return view
    }

}