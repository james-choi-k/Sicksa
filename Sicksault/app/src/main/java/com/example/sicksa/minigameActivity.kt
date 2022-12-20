package com.example.sicksa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.minigame.*


class minigameActivity : AppCompatActivity() {


    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.minigame)

        rolbtn.setOnClickListener({
            val intent = Intent(this, rouletActivity::class.java)
            startActivity(intent)
        })

        mole.setOnClickListener({
            val intent = Intent(this, moleActivity::class.java)
            startActivity(intent)
        })

        worldcup.setOnClickListener({
            val intent = Intent(this, wcupActivity::class.java)
            startActivity(intent)
        })

        zebi.setOnClickListener({
            val intent = Intent(this, zebiActivity::class.java)
            startActivity(intent)
        })
    }
}