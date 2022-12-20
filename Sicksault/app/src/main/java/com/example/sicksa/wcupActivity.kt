package com.example.sicksa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class wcupActivity : AppCompatActivity() {

    data class Food(val id: Int, val name: String, val src: Int)

    val chicken = Food(0, "치킨", R.drawable.chicken)
    val pizza = Food(1, "피자", R.drawable.pizza)
    val hamburger = Food(2, "햄버거", R.drawable.hamburger)
    val ramen = Food(3, "라면", R.drawable.ramen)
    val spaghetti = Food(4, "스파게티", R.drawable.spaghetti)
    val toast = Food(5, "토스트", R.drawable.toast)
    val sushi = Food(6, "스시", R.drawable.sushi)
    val donkatsu = Food(7, "돈까스", R.drawable.donkatsu)
    val foodArray = arrayOf(chicken, pizza, hamburger, ramen, spaghetti, toast, sushi, donkatsu)
    var gameSize = foodArray.size

    fun main() {
        setContentView(R.layout.wcup)

        val leftImg : ImageView = findViewById(R.id.leftContentImg)
        val rightImg : ImageView = findViewById(R.id.rightContentImg)
        val leftTxt : TextView = findViewById(R.id.leftContentTxt)
        val rightTxt : TextView = findViewById(R.id.rightContentTxt)
        val leftChoose : Button = findViewById(R.id.leftContentChoose)
        val rightChoose : Button = findViewById(R.id.rightContentChoose)
        val winner : TextView = findViewById(R.id.winnerContent)
        val gameStatusTxt : TextView = findViewById(R.id.gameStatusTxt)

        fun worldcupGame(game: Int) {

            gameStatusTxt.text = "${game} 강"
            var temp = 1

            fun worldcupSet(idx: Int) {
                leftImg.visibility = View.VISIBLE
                rightImg.visibility = View.VISIBLE
                leftImg.setImageResource(foodArray[idx].src)
                rightImg.setImageResource(foodArray[idx + 1].src)
                leftChoose.setEnabled(true);
                rightChoose.setEnabled(true);
                leftTxt.text = foodArray[idx].name
                rightTxt.text = foodArray[idx + 1].name
                leftChoose.text = foodArray[idx].name
                rightChoose.text = foodArray[idx + 1].name
                winner.text = ""

                leftChoose.setOnClickListener {
                    winner.text = "라운드 승리자: ${foodArray[idx].name}"
                    rightImg.visibility = View.INVISIBLE
                    rightChoose.setEnabled(false)
                    if (idx < gameSize - 2) {
                        if (idx != 0) {
                            foodArray[temp] = foodArray[idx]
                            temp++
                        } else {
                            foodArray[1] = foodArray[0]
                        }
                        Handler().postDelayed({
                            worldcupSet(idx + 2)
                        }, 1_000)
                    } else if (gameSize > 2) {
                        foodArray[temp] = foodArray[idx]
                        temp++
                        Handler().postDelayed({
                            gameSize /= 2
                            worldcupGame(gameSize)
                        }, 1_000)
                    } else {
                        leftChoose.setEnabled(false);
                        rightChoose.setEnabled(false);
                        winner.text = "우승!: ${foodArray[idx].name}"
                    }
                }

                rightChoose.setOnClickListener {
                    winner.text = "라운드 승리자: ${foodArray[idx + 1].name}"
                    leftImg.visibility = View.INVISIBLE
                    leftChoose.setEnabled(false);
                    if (idx < gameSize - 2) {
                        if (idx != 0) {
                            foodArray[temp] = foodArray[idx + 1]
                            temp++
                        } else {
                            foodArray[0] = foodArray[1]
                        }
                        Handler().postDelayed({
                            worldcupSet(idx + 2)
                        }, 1_000)
                    } else if (gameSize > 2){
                        foodArray[temp] = foodArray[idx + 1]
                        temp++
                        Handler().postDelayed({
                            gameSize /= 2
                            worldcupGame(gameSize)
                        }, 1_000)
                    } else {
                        leftChoose.setEnabled(false);
                        rightChoose.setEnabled(false);
                        winner.text = "우승!: ${foodArray[idx + 1].name}"
                    }
                }
            }

            worldcupSet(0)

        }

        worldcupGame(gameSize);
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main()
    }
}