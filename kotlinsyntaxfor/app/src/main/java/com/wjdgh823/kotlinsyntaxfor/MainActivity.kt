package com.wjdgh823.kotlinsyntaxfor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intArray = intArrayOf(0,1,2,3,4,5,6,7,8)

        // for
        // 일반적으로 몇 번의 횟수를 반복하는 형태
        for(value in intArray) {
            Log.d("반복목", "index=${value}")
        }

        for(index in 1 until 100) { // 마지막 값은 뺴고 출력
            Log.d("반복목", "index=${index}")
        }

        // while
        var out = 0
        while (out < 3) {
            Log.d("while", "현재 out 카운트 =${out}")
            out = out + 1
        }

        // control loop
        for (index in 0..10) {
            if (index > 5) break // 5이상일 경우 그만,
            // if (index == 5) continue // 5일때는 5는 실행하지말고 넘어가라라
           Log.d("for" , "현재숫자 = ${index}")
        }

    }
}