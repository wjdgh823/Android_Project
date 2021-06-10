package com.wjdgh823.aop_part2_chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // activity_main이라는 액티비티를 가져와서 액티비티에 setContentView로 설정하겠다.

        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText) // id값을 찾기 위한 방법

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {  // setOnClickListener는 버튼을 눌렀을때 반응하는 함수
            Log.d("MainActivity", "ResultButton이 클릭되었습니다.")
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show() // alert이라고 보면 된다.
                return@setOnClickListener // return 으로 빠져나갈 함수를 지정한다.
            }
            // 이 아래로는 절대 빈값이 올 수 없음

            val height:Int = heightEditText.text.toString().toInt() // 신장에 대한 정보가 입력된 내용을 저장
            val weight:Int = weightEditText.text.toString().toInt() // 체중에 대한 정보가 입력된 내용을 저장

            val intent = Intent(this, ResultActivity::class.java) // MainActivity에서 ResultActivity을 실행시키는 방법
            intent.putExtra("height", height)  // intent에 입력된 값을 저장하는 방법
            intent.putExtra("weight", weight)  // ""

            startActivity(intent) // 보내기 위한 최종 방법
        }

    }
}