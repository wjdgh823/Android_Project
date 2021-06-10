package com.wjdgh823.aop_part2_chapter01

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result) // xml을 연결한다

        val height = intent.getIntExtra("height",0)
        // 넘겨온 값을 받는 방법
        // height값이 없을 경우 나타날 변수 (2번쨰 인자)
        val weight = intent.getIntExtra("weight", 0)
        Log.d("ResultActivity", "height : $height , weight : $weight")

        val bmi = weight / (height / 100.0).pow(2.0)
        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString() // bmi 결과를 입력해주는 -> bmi는 더블타입이기에 toString처리
        resultStringTextView.text = resultText    // 체중에대한 결과를 입력해준다.

    }

}