package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.simplecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addButton.setOnClickListener{ calculationLogic(1) }
        binding.subtractButton.setOnClickListener{ calculationLogic(2) }
        binding.multiplyButton.setOnClickListener{ calculationLogic(3) }
        binding.divideButton.setOnClickListener{ calculationLogic(4) }
    }

    private fun calculationLogic(operation: Int) {
        val firstNumberText = binding.firstNumber.text.toString()
        val secondNumberText = binding.secondNumber.text.toString()

        if (firstNumberText.isEmpty() || firstNumberText.isEmpty()) {
            Toast.makeText(this, "Please enter your number", Toast.LENGTH_SHORT).show()
            return
        }

        val firstNumber = firstNumberText.toIntOrNull()
        val secondNumber = secondNumberText.toIntOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = when (operation) {
                1 -> firstNumber + secondNumber
                2 -> firstNumber - secondNumber
                3 -> firstNumber * secondNumber
                4 -> if (secondNumber != 0) firstNumber / secondNumber else {
                    Toast.makeText(this, "You can not divide to zero", Toast.LENGTH_SHORT).show()
                    return
                }

                else -> 0
            }
            binding.resultText.text = result.toString()
        }
        else{
            Toast.makeText(this,"Please enter only numbers", Toast.LENGTH_SHORT).show()
        }
    }
}