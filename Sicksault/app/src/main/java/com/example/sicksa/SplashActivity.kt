package com.example.sicksa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed( {
          val intent = Intent(baseContext, MainActivity::class.java)
          startActivity(intent)
          finish()
        }, 5000 )
        // 2초 기다린 후에
        // MainActivity를 실행시킨 후 현재 열려있는 창(Splash 창)을 종료시켜준다.
    }
}