package com.ege.examples.example_templates.data_from_fragment_to_activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.ege.examples.R

class MyFragment : Fragment() {

    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var send : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_my, container, false)

        name = view.findViewById(R.id.editTextName2)
        email = view.findViewById(R.id.editTextEmail2)
        send = view.findViewById(R.id.buttonSend)

        send.setOnClickListener {

            val userName = name.text.toString()
            val userEmail = email.text.toString()

           // val mainActivity : MainActivity = activity as MainActivity
           // mainActivity.takeData(userName, userEmail)

            (activity as DataTransferFtoAActivity).takeData(userName, userEmail)

        }

        // Inflate the layout for this fragment
        return view
    }

}