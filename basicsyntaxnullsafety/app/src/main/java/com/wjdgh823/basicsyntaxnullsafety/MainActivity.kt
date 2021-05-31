package com.wjdgh823.basicsyntaxnullsafety

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName:String = "메시"
        var number:Int? = null// 1.nullable
        var newVariable: Activity? = null

        Log.d("Null Test", "문자열의 길이는=${myName.length}")

        // Null Pointer Exception
        var result = number?.plus(37) ?: 51
        // number?를 사용하면 null처리가 가능하다.
        // ?: 처리를 한다면 null 대신 입력될 값을 설정가능하다.
        var result2 = result.plus(53)
    }
}