package com.example.sicksa

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.choice.*
import kotlinx.android.synthetic.main.minigame.*
import java.util.*

class rouletActivity : AppCompatActivity() {
    var iv_roulette: ImageView? = null
    var startDegree = 0f
    var endDegree = 0f

    override fun onCreate(saveInstanceState: Bundle?) {
        super.onCreate(saveInstanceState)
        setContentView(R.layout.roulet)

        // 애니메이션 이미지 인식
        iv_roulette = findViewById<View>(R.id.roulette) as ImageView

    }

    // 룰렛 이미지 터치 시에 호출되는 메소드
    fun rotate(v: View?) {
        // ---------- 회전각도 설정 ----------
        startDegree = endDegree // 이전 정지 각도를 시작 각도로 설정
        val rand = Random() // 랜덤 객체 생성
        val degree_rand: Int = rand.nextInt(360) // 0~359 사이의 정수 추출
        endDegree =
            startDegree + 360 * 5 + degree_rand // 회전 종료각도 설정(초기 각도에서 세바퀴 돌고 0~359 난수만큼 회전)

        // ---------- 애니메이션 실행 ----------
        // 애니메이션 이미지에 대해 초기 각도에서 회전종료 각도까지 회전하는 애니메이션 객체 생성
        val `object` =
            ObjectAnimator.ofFloat(iv_roulette, "rotation", startDegree, endDegree)
        `object`.interpolator = AccelerateDecelerateInterpolator() // 애니메이션 속력 설정
        `object`.duration = 6000 // 애니메이션 시간(5초)
        `object`.start() // 애니메이션 시작
    }
}


