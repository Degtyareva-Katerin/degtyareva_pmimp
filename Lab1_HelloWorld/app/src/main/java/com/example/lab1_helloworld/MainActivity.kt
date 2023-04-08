package com.example.lab1_helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var editTxt: EditText? = null
    private var result_info: TextView? = null
    private var main_btn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTxt = findViewById(R.id.editTextName)
        main_btn=findViewById(R.id.btnName)
        result_info=findViewById(R.id.textViewName)

        main_btn?.setOnClickListener{
            result_info?.text =editTxt?.text.toString()
        }

    }
}