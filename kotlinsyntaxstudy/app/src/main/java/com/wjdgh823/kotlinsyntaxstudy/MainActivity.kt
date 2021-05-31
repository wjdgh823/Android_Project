package com.wjdgh823.kotlinsyntaxstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // * var 변수 선언은 변수값을 변경가능하다.
        var myname = "나정호"
        Log.d(TAG, "my name=$myname")
        myname = "김진월"
        Log.d(TAG, "my name=$myname")

        // * val선언은 변수를 변경할 수 없다. 지정된 값들을 저장할 때 사용
        val PI = 3.14
        Log.d(TAG, "PI=$PI")


        var myNumbers = "1,2,3,4,5,6"
        var thisWeekNumbers = "5,6,7,8,9,10"

        if (myNumbers == thisWeekNumbers) {
            textLog.text = "당첨되었습니다."  // textLog 라고 화면에 지정한 id가 있음
        } else {
            textLog.text = "당첨되지 않았습니다."
        }

        for( idx in 1..10 ) {  // for문을 사용할 때
            textLog.append("\n현재 숫자는 ${idx} 입니다.") // \n은 새로운 라인이라는 걸 알려준다
        }
    }
}