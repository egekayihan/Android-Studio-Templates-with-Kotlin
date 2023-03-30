package com.ege.examples.example_templates

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ege.examples.R
import com.ege.examples.example_templates.adapters.CountriesAdapter

class RecyclerActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    var countryNameList = ArrayList<String>()
    var countryDescList = ArrayList<String>()
    var countryImageList = ArrayList<Int>()

    lateinit var adapter : CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this@RecyclerActivity)


        countryNameList.add("Sweden")
        countryNameList.add("Mexico")
        countryNameList.add("Australia")

        countryDescList.add("This is the Sweden flag")
        countryDescList.add("This is the Mexico flag")
        countryDescList.add("This is the Australia flag")

        countryImageList.add(R.drawable.sweden)
        countryImageList.add(R.drawable.mexico)
        countryImageList.add(R.drawable.australia)

        adapter = CountriesAdapter(countryNameList, countryDescList, countryImageList, this@RecyclerActivity)

        recyclerView.adapter = adapter

    }
}