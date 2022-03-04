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
        binding.edTimes.setText("5")
        binding.edNumber.setText("0")
    }
    var mins = 1
    var maxs = 100
    var min = 1
    var max = 100
    var secret = 0
    var num = 0
    var chancetimes = 0
    var guessedtimes = 0

    fun start(view: View) {
        if (binding.edTimes.text != null) {
            guessedtimes = 0
            chancetimes = binding.edTimes.text.toString().toInt()
            binding.tvRange.text = "$mins - $maxs"
            min = mins
            max = maxs
            secret = (mins..maxs).random()
            binding.edNumber.text.clear()
            binding.tvResult.text = ""
            println("The secret number is $secret!")
        } else {
            binding.tvResult.text = "Please enter how many chances you want to guess."
            println("Please enter the chance times.")
        }
    }

    fun guess(view : View) {
        num = binding.edNumber.text.toString().toInt()
        if (guessedtimes < chancetimes-1) {
            if (num >= min && num <= max) {
                guessedtimes++
                println("have guessed $guessedtimes/$chancetimes time(s)")
                if (num < secret) {
                    min = num
                    binding.tvResult.text = "Wrong! Have guessed $guessedtimes/$chancetimes time(s)."
                    binding.edNumber.text.clear()
                    binding.tvRange.text = "$min - $max"
                } else if (num > secret) {
                    max = num
                    binding.tvResult.text = "Wrong! Have guessed $guessedtimes/$chancetimes time(s)."
                    binding.edNumber.text.clear()
                    binding.tvRange.text = "$min - $max"
                } else {
                    binding.tvResult.text = "Bingo! you got the number : $secret"
                }
            } else {
                binding.tvResult.text = "Please guess number in range!!! Have guessed $guessedtimes/$chancetimes time(s)."
                binding.edNumber.text.clear()
            }
        } else if (guessedtimes == chancetimes-1) {
            guessedtimes++
            println("have guessed $guessedtimes/$chancetimes time(s)")
            if (num != secret) {
                binding.tvResult.text = "Game Over. The number is $secret."
            } else {
                binding.tvResult.text = "Bingo! you got the number: $secret"
            }
        } else {
            binding.tvResult.text = "Run out of chances."
            binding.tvRange.text = "Please restart."
            binding.edNumber.text.clear()
        }
    }
}