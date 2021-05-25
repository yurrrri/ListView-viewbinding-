package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listview.databinding.ActivityMainBinding

data class BusinessCard(val name:String,val contents:String)

class MainActivity : AppCompatActivity() {

    var businessCardArrayList = ArrayList<BusinessCard>()
    private lateinit var customAdapter:CustomAdapter
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)

        val view =binding.root
        setContentView(view)

        for(x in 0..30)
        {

            businessCardArrayList.add(BusinessCard("록","하이"))
            businessCardArrayList.add(BusinessCard("담","하이"))
            businessCardArrayList.add(BusinessCard("록","하이"))
            businessCardArrayList.add(BusinessCard("담","하이"))

        }
        customAdapter= CustomAdapter(this,businessCardArrayList)

        binding.listviewMain.adapter=customAdapter
    }
}