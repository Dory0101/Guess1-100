package com.example.guessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.guessapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //get view
    }


    fun guess(view : View) {
        var secret = (2..10).random()
        var num = binding.edNumber.text.toString().toInt()
        if (num != secret) {
            println("Wrong! The secret number is $secret!")
        } else {
            println("Bingo! you got the number$secret")
        }
    }
}