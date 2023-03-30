package com.ege.examples.example_templates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ege.examples.databinding.ActivityMainBinding
import com.ege.examples.databinding.ActivityViewbindingBinding

class ViewBindingActivity : AppCompatActivity() {

    lateinit var viewbindingBinding : ActivityViewbindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewbindingBinding = ActivityViewbindingBinding.inflate(layoutInflater)
        val view = viewbindingBinding.root

        setContentView(view)

        viewbindingBinding.buttonOk.setOnClickListener {

            viewbindingBinding.textViewResult.text = viewbindingBinding.editTextName.text.toString()

        }

    }

}