package com.ege.examples.example_templates.data_from_fragment_to_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.R

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view : View = inflater.inflate(R.layout.fragment_first2, container, false)

        val name : EditText = view.findViewById(R.id.editTextName3)
        val send : Button = view.findViewById(R.id.buttonSend2)

        send.setOnClickListener {

            val userName = name.text.toString()
            val bundle = Bundle()

            bundle.putString("username", userName)

            val secondFragment = SecondFragment()
            secondFragment.arguments = bundle

            val fm : FragmentManager = requireActivity().supportFragmentManager
            val ft : FragmentTransaction = fm.beginTransaction()

            ft.replace(R.id.frame, secondFragment)

            ft.commit()

        }


        // Inflate the layout for this fragment
        return view
    }

}