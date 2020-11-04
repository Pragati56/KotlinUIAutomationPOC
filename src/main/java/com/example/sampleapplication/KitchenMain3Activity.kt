package com.example.sampleapplication

import android.os.Bundle

import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


import kotlinx.android.synthetic.main.kitchen_main3.*
import android.content.Intent



class KitchenMain3Activity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager



    private val kitchenitemtoadd = KitchenFragmentItem()
    private val kitchenitemtoView = KitchenFragmentView()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kitchen_main3)


        /* Display First Fragment initially
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.myFragment, kitchenitemtoView)
        fragmentTransaction.commit()*/


        println("Kitchen has these items" )
    }

    fun btnOne(v:View){

        var intent = packageManager.getLaunchIntentForPackage("com.grofers.customerapp")
        if (intent != null) {
            // We found the activity now start the activity
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        } else {
            // Bring user to the market or let them choose an app?
            intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent = packageManager.getLaunchIntentForPackage("com.android.vending")
            startActivity(intent)
        }
       /* val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.myFragment, kitchenitemtoadd)

        fragmentTransaction.commit()*/
    }

    fun btnTwo(v:View){

        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.myFragment, kitchenitemtoView)

        fragmentTransaction.commit()
    }

}
