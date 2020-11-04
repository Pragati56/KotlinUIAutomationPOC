package com.example.sampleapplication

import android.os.Bundle

import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_main2.*
import android.content.Intent
import android.R.attr.button
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val foodList = arrayListOf("milk ","bread ","fruits ","vegetable ")
        var itemsForKitchen: String?=null
        button.setOnClickListener {
            val newFoodItem = selectGrocery.text.toString()
            listOfGrocerry.text.clear()
            selectGrocery.text.clear()
            foodList.add(newFoodItem+" ")
            println(" list of item "+foodList)
            for (list in foodList)
            {
                listOfGrocerry.text.append(list).append(" ")
                itemsForKitchen =listOfGrocerry.text.toString()

            }

        }
        button2.setOnClickListener{

                val intent = Intent(this@Main2Activity, KitchenMain3Activity::class.java)
                intent.putExtra("KitchenItem",itemsForKitchen)
                startActivity(intent)




        }
        







    }
}

