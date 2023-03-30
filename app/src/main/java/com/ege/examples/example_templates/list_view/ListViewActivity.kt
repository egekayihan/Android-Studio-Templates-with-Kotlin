package com.ege.examples.example_templates.list_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.ege.examples.R
import com.ege.examples.example_templates.list_view.MyListFragment

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)

        val fragmentManager : FragmentManager = supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()

        val myListFragment = MyListFragment()

        fragmentTransaction.add(R.id.frame, myListFragment)

        fragmentTransaction.commit()

    }


}