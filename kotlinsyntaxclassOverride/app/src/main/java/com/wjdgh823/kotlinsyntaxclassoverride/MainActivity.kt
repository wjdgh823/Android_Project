package com.wjdgh823.kotlinsyntaxclassoverride

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var parent = Parent()
        parent.showHouse()

        var child = Child()

        child.showHouse()


        var son = Son()
        //var result1 = son.getNumber("홍")

    }
}



open class Parent {
    var money = 5000000
    open var house = "강남 200평 아파트"

    open fun showHouse() {
        Log.d("클래스", "아빠의 집=${house}")
    }
}

class Child:Parent() {
    override var house = "강남 10평 오피스텔"

    fun showMoney() {
        Log.d("클래스" , "money=${money}")
    }
    override fun showHouse() {
        Log.d("클래스", "자식의 집=${house}")
    }
}

class Son {

    fun getNumber():Int {
        return 1
    }

    fun getNumber(param:String, hidra:String) : Int {
        return 2
    }

}