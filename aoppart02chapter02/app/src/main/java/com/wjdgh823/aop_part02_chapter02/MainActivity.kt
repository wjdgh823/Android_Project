package com.wjdgh823.aop_part02_chapter02

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    // id 값들을 변수로 저장하기 위한 방법들이다.
    private val clearButton: Button by lazy {
        findViewById<Button>(R.id.clearButton)
    }
    private val addButton: Button by lazy {
        findViewById<Button>(R.id.addButton)
    }
    private val runButton: Button by lazy {
        findViewById<Button>(R.id.runButton)
    }
    private val numberPicker: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker)
    }

    private val numberTextViewList: List<TextView> by lazy {  // 리스트에 한꺼번에 값을 넣어서 처리한다.
        listOf<TextView>(
            findViewById<TextView>(R.id.TextView1),
            findViewById<TextView>(R.id.TextView2),
            findViewById<TextView>(R.id.TextView3),
            findViewById<TextView>(R.id.TextView4),
            findViewById<TextView>(R.id.TextView5),
            findViewById<TextView>(R.id.TextView6)
        )
    }

    private var didRun = false

    private val pickNumberSet = hashSetOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.minValue = 1  // numberPicker의 범위 최소값
        numberPicker.maxValue = 45 // numberPicker의 범위 최대값

        initRunButton()
        initAddButton()
        initClearButton()

    }

    private fun initRunButton() {
        runButton.setOnClickListener {
            val list = getRandomNumber()
            didRun = true
            list.forEachIndexed { index, number ->
                val textView = numberTextViewList[index]
                textView.text = number.toString()
                textView.isVisible = true
                setNumberBackground(number, textView) // 함수를 이용해서 값을 바꾸는 함수를 빌드했다.
            }
        }
    }

    private fun initAddButton() {
        addButton.setOnClickListener {
            if (didRun) {
                Toast.makeText(this, "초기화 후에 시도해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pickNumberSet.size >= 5) {
                Toast.makeText(this, "번호는 5개까지만 선택가능", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pickNumberSet.contains(numberPicker.value)) {
                Toast.makeText(this, "이미 선택한 번호입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val textView = numberTextViewList[pickNumberSet.size]
            textView.isVisible = true
            textView.text = numberPicker.value.toString()

            setNumberBackground(numberPicker.value, textView)

            pickNumberSet.add(numberPicker.value)
        }
    }

    private fun setNumberBackground(number:Int, textView: TextView) {
        when (number) {
            in 1..10 ->  textView.background = ContextCompat.getDrawable(this, R.drawable.circle_yellow)
            in 11..20 ->  textView.background = ContextCompat.getDrawable(this, R.drawable.circle_blue)
            in 21..30 ->  textView.background = ContextCompat.getDrawable(this, R.drawable.circle_red)
            in 31..40 ->  textView.background = ContextCompat.getDrawable(this, R.drawable.circle_gray)
            else -> textView.background = ContextCompat.getDrawable(this, R.drawable.circle_green)
        }
    }

    private fun initClearButton() {
         clearButton.setOnClickListener {
             pickNumberSet.clear() // 클리어 시켜준다.
             numberTextViewList.forEach {  // 리스트의 값을 하나하나씩 꺼내서 실행한다.
                 it.isVisible = false // 추가했던 5개의 textview를 숨기는 역할을 실행
             }
             didRun = false
         }
    }

    private fun getRandomNumber(): List<Int> { // int형 리스트 반환하는 것을 설정
        val numberList = mutableListOf<Int>()
            .apply { // 값을 리스트를 넣기 위한 설정
                for(i in 1..45) {
                    if (pickNumberSet.contains(i)) { // 이미 포함하고 있는 숫자가 있으면 다른 숫자를 받는다
                        continue
                    }
                    this.add(i) // this는 numberList이다
                }
            }
        numberList.shuffle() // numberList의 숫자들을 섞어준다. 랜덤으로
        val newList =pickNumberSet.toList() +  numberList.subList(0, 6 - pickNumberSet.size) // subString() 같은 역할을 한다고 생각해라
        return newList.sorted() // 리스트의 값을 오름차순으로 정렬한다.
    }

}