
package com.example.sampleapplication
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sampleapplication.R


class KitchenFragmentView : Fragment() {

    lateinit var textView:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kitchen_fragment_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textView = view.findViewById(R.id.second_fragment_text)
        textView.text  = "View Kitchen Item"
    }
}