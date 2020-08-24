package com.example.newphotohorizontal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter:Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = Adapter()
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_horizontal.layoutManager = layoutManager
        rv_horizontal.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        rv_horizontal.adapter = adapter
    }
}