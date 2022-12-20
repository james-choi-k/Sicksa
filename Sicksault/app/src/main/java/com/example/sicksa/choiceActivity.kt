package com.example.sicksa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.choice.*
import kotlinx.android.synthetic.main.minigame.*

class choiceActivity : AppCompatActivity() {
    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.choice)

        img1.setOnClickListener({
            val intent = Intent(this, hansikActivity::class.java)
            startActivity(intent)
        })

        img2.setOnClickListener({
            val intent = Intent(this, chickActivity::class.java)
            startActivity(intent)
        })

        img3.setOnClickListener({
            val intent = Intent(this, junActivity::class.java)
            startActivity(intent)
        })

        img4.setOnClickListener({
            val intent = Intent(this, illActivity::class.java)
            startActivity(intent)
        })

        img5.setOnClickListener({
            val intent = Intent(this, bunActivity::class.java)
            startActivity(intent)
        })

        img6.setOnClickListener({
            val intent = Intent(this, sulActivity::class.java)
            startActivity(intent)
        })

        img7.setOnClickListener({
            val intent = Intent(this, dezuActivity::class.java)
            startActivity(intent)
        })


    }
}

