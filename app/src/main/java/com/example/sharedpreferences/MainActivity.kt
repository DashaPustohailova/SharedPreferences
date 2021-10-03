package com.example.sharedpreferences

import android.content.Context
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        binding.apply {

            if(pref.contains("DATA")){
                ptData.setText(pref.getString("DATA",""))
            }

            btSave.setOnClickListener {
                editor.putString("DATA", ptData.text.toString())
                editor.apply()
            }

            btClear.setOnClickListener {
                editor.clear()
                editor.apply()
            }
        }
    }
}