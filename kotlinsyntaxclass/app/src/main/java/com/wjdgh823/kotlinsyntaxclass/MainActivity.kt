package com.wjdgh823.kotlinsyntaxclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var child = Child() // 클래스를 초기화
        child.showMoney()

    }
}

// 상속을 사용하는 이유
// 1. 기존에 작성된 코드를 재활용하기 위해서
// 2. 코드를 재활용하는데 좀 더 체계젹으로 계층구조화해서 사용하기 위해서

open class Parent {  // 상속을 하기 위해서 class 앞에 "open"이라고 작성해야 사용 가능
    var money = 50000000
    var house = "강남 200평 아파트"
}

class Child : Parent() {
    // 상속받으면, 아빠 클래스의 프로퍼티와 메서드를 내것처럼 사용가능
    fun showMoney() {
        Log.d("클래스", "money=${money}")
    }
}
