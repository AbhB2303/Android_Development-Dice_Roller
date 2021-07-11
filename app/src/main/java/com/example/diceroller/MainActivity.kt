package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var diceImage1 : ImageView //store value once here to avoid expensive operation
    lateinit var diceImage2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage1 = findViewById(R.id.dice_image1)
        diceImage2 = findViewById(R.id.dice_image2)
        //diceImage2 = findViewById(R.id.dice_image)
        //val countButton: Button = findViewById(R.id.countup_button)
        //countButton.setOnClickListener{ countUp() }
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        //findViewById is an expensive task and should be limited
        //Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        //val resultText2: TextView = findViewById<TextView>(R.id.result_text)
        val randomInt1 = (1..6).random()
        val randomInt2 = (1..6).random()
        //val diceImage: ImageView = findViewById<ImageView>(R.id.dice_image)
        val drawableResource1 = getRandomDiceImage()
        val drawableResource2 = getRandomDiceImage()
        diceImage1.setImageResource(drawableResource1)
        diceImage2.setImageResource(drawableResource2)
        val Total = randomInt1 + randomInt2
        resultText.text = Total.toString()
        //resultText2.text = randomInt2.toString()
    }

    private fun getRandomDiceImage(): Int {
        return when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            var resultInt = resultText.text.toString().toInt()

            if(resultInt < 6)
                resultInt++
                resultText.text = resultInt.toString()
        }
        val drawableResource = when (resultText.text.toString().toInt()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage1.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource)
    }
}