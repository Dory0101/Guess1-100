package com.example.guessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guessapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //get view
    }
}