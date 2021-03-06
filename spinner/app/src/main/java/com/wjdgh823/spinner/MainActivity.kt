package com.wjdgh823.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = listOf("- 선택하세요 -", "월", "화", "수", "목", "금", "토", "일")

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedValue = data[position]
                textView.text = selectedValue // 받아온 값을 textView 아이디의 값에 저장되어 함께 변경
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }
    }
}