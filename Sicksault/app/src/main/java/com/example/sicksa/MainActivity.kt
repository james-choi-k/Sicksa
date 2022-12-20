package com.example.sicksa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.choice.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener({
            val intent = Intent(this, choiceActivity::class.java)
            startActivity(intent)
        })

        button2.setOnClickListener({
            val intent = Intent(this, landomActivity::class.java)
            startActivity(intent)
        })

        button3.setOnClickListener({
            val intent = Intent(this, minigameActivity::class.java)
            startActivity(intent)
        })

        button5.setOnClickListener({
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        })



//
    }
}