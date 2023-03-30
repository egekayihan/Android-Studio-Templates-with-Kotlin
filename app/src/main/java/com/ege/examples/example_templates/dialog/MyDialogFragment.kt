package com.ege.examples.example_templates.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.ege.examples.MainActivity
import com.ege.examples.R

class MyDialogFragment : DialogFragment() {

    lateinit var name : EditText
    lateinit var age : EditText
    lateinit var cancel : Button
    lateinit var ok : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_my_dialog, container, false)

        name = view.findViewById(R.id.editTextDialogName)
        age = view.findViewById(R.id.editTextDialogAge)
        cancel = view.findViewById(R.id.buttonDialogCancel)
        ok = view.findViewById(R.id.buttonDialogOk)

        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)

        ok.setOnClickListener {

            val userName : String = name.text.toString()
            val userAge : Int = age.text.toString().toInt()

            val mainActivity : DialogActivity = activity as DialogActivity

            mainActivity.getUserData(userName, userAge)

            dialog!!.dismiss()

        }

        cancel.setOnClickListener {

            dialog!!.dismiss()

        }

        // Inflate the layout for this fragment
        return view
    }

}