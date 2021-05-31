package com.wjdgh823.kotlinsyntaxcondition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var first = 300
        var second = 500
        var third = 270

        // 비교연산자 <. >, >=, <=, ==, !=
        var result1 = first > 500
        Log.d("compare", "첫번째 결과 : ${result1}")
        var result2 = second < 500
        Log.d("compare", "첫번째 결과 : ${result2}")

        // 논리연산자
        var logic1 = result1 && result2
        Log.d("compare", "논리연산 && 결과 : ${logic1}")
        var logic2 = result1 || result2
        Log.d("compare", "논리연산 || 결과 : ${logic2}")
        var logic3 = !result1
        Log.d("compare", "논리연산 ! 결과 : ${logic3}")

        // if
        /*
        if (조건식 = 비교연산 + 논리연산) {
            // 코드블록
        } else {
            // 위의 if 조건을 만족하지 않았을 때 실행되는 코드블럭
        }
        */

        var month = 7
        if (month > 9) {
            Log.d("if", "가을 옷을 입자!")
        } else if (month > 9 && month > 6) {
            Log.d("if", "해수욕장을 갑니다!")
        } else {
            Log.d("if", "집에 있습니다!")
        }

        // 코틀린의 when - if문의 확장판판
        when(month) {
            9,10,11,12 -> Log.d("when", "가을 옷을 입습니다.")
            7,8        -> Log.d("when", "해수욕장을 갑니다.")
            4, 5, 6    -> Log.d("when", "소풍을 갑니다.")
            else       -> Log.d("when", "집에 있습니다.")
        }




    }
}