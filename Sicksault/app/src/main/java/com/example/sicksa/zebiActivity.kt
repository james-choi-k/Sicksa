package com.example.sicksa

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class zebiActivity : AppCompatActivity() {
    data class Food(var name: String, var correct: Int, var image: Int)
    var chicken = Food("치킨", 0, R.drawable.chicken)
    var pizza = Food("피자", 0, R.drawable.pizza)
    var hamburger = Food("햄버거", 0, R.drawable.hamburger)
    var ramen = Food("라멘", 0, R.drawable.ramen)
    var foodArray = arrayOf(chicken, pizza, hamburger, ramen)

    fun main() {
        setContentView(R.layout.zebi)

        val btn01 : Button = findViewById(R.id.button1)
        val btn02 : Button = findViewById(R.id.button2)
        val btn03 : Button = findViewById(R.id.button3)
        val btn04 : Button = findViewById(R.id.button4)
        val btnArray = arrayOf(btn01, btn02, btn03, btn04)

        val random = (0..3).random()

        for (i: Int in 0..3) {
            btnArray[i].text = foodArray[i].name
            if (i == random) {
                foodArray[i].correct = 1
            }
        }

        val resultTxt : TextView = findViewById(R.id.textView2)
        val resultImg : ImageView = findViewById(R.id.foodImg)

        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        val colored = ColorMatrix()
        colored.setSaturation(1f)

        val filter = ColorMatrixColorFilter(matrix)
        val coloring = ColorMatrixColorFilter(colored)

        btn01.setOnClickListener {
            if (foodArray[0].correct == 1) {
                resultTxt.text = "당첨!"
                for (i: Int in 0..3) {
                    btnArray[i].isEnabled = false
                }
                resultImg.setImageResource(chicken.image)
                resultImg.setColorFilter(coloring)
            } else {
                resultTxt.text = "꽝..."
                resultImg.setImageResource(chicken.image)
                resultImg.setColorFilter(filter)
            }
        }

        btn02.setOnClickListener {
            if (foodArray[1].correct == 1) {
                resultTxt.text = "당첨!"
                for (i: Int in 0..3) {
                    btnArray[i].isEnabled = false
                }
                resultImg.setImageResource(pizza.image)
                resultImg.setColorFilter(coloring)
            } else {
                resultTxt.text = "꽝..."
                resultImg.setImageResource(pizza.image)
                resultImg.setColorFilter(filter)
            }
        }

        btn03.setOnClickListener {
            if (foodArray[2].correct == 1) {
                resultTxt.text = "당첨!"
                for (i: Int in 0..3) {
                    btnArray[i].isEnabled = false
                }
                resultImg.setImageResource(hamburger.image)
                resultImg.setColorFilter(coloring)
            } else {
                resultTxt.text = "꽝..."
                resultImg.setImageResource(hamburger.image)
                resultImg.setColorFilter(filter)
            }
        }

        btn04.setOnClickListener {
            if (foodArray[3].correct == 1) {
                resultTxt.text = "당첨!"
                for (i: Int in 0..3) {
                    btnArray[i].isEnabled = false
                }
                resultImg.setImageResource(ramen.image)
                resultImg.setColorFilter(coloring)
            } else {
                resultTxt.text = "꽝..."
                resultImg.setImageResource(ramen.image)
                resultImg.setColorFilter(filter)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        main()
    }
}