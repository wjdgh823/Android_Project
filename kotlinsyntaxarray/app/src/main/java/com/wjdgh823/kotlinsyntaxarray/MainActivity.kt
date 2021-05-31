package com.wjdgh823.kotlinsyntaxarray

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var variable:Int = 157

        // * 배열
        // Int -> IntArray
        var intArr:IntArray = IntArray(10) // 10개의 배열을 선언하는 것
        // index = 0부터 시작
        intArr[0] = 10
        intArr[1] = 20
        intArr[2] = 30
        intArr[3] = 40
        intArr[4] = 50
        intArr[5] = 60
        intArr[6] = 70
        intArr[7] = 80
        intArr[8] = 90
        intArr[9] = 100

        Log.d("array", "9번 인덱스의 값=${intArr[9]}")

        var weekArray = CharArray(12)
        weekArray[0] = '월'
        weekArray[1] = '화'
        // ....
        weekArray[6] = '일'


        // * 컬렉션      Generic(제네릭) 으로 지정할 타입을 선언한다.
        // 리스트, 뮤터블리스트
        var mutablelist = mutableListOf<Int>()
        // 값 넣기
        mutablelist.add(5)  // index 0
        mutablelist.add(10) // 1
        mutablelist.add(75) // 2
        mutablelist.add(36) // 3

        Log.d("컬렉션", "3번 인덱스이 값 : ${mutablelist.get(3)}")
        // list에서 값을 가져오기 위해서는 get함수를 사용한다.


        // * 맵 (key, value)
        var mutableMap = mutableMapOf<String, String>()
        mutableMap.put("변수1", "값1")
        mutableMap.put("변수2", "값2")

        Log.d("컬렉션", "맵 변수1의 값 : ${mutableMap.get("변수1")}")

    }
}