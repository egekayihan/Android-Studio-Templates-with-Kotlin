package com.ege.examples.example_templates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ege.examples.R

class ImagePixelResActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.lion2)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        setContentView(R.layout.activity_main)

    }


}