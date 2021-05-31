package com.wjdgh823.kotlinsyntaxvar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var variable:String = "나정호"
        // 한번 타입을 선언해주면 다른 타입의 값을 넣어주지 못한다
        // 그렇기에 타입의 값을 선언해주는 습관을 들이는것이 좋다.

        var variable2:String // 어떤 타입의 값을 받을지 선언
        variable2 = "안녕하세요!"


        // 코틀린의 기본타입

        // 실수형
        var doubleValue:Double = 35.6
        var floatValue:Float = 123.7f

        // 정수형
        var intValue:Int = 12345
        var longValue:Long = 2_147_483_647
        var shortValue:Short = 123
        var byteValue:Byte = 127

        // 문자형
        var charValue:Char = 'a'
        var stringValue:String = "문자형 길이에 상관없이 값을 입력할 수 있다 = 크기를 특정할 수 없다."

        // 불린형
        var booleanValue:Boolean = true
        booleanValue = false

        // 상수형 : 지정된 값
        val valValue:Boolean = true


    }

}