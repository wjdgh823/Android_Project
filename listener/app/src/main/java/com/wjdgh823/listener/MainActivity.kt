package com.wjdgh823.listener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listener = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("리스너", "클릭되었습니다.")
            }
        }

        button.setOnClickListener(listener) // 위의 선언된 리스너를 불러드려서 사용하는 법

        // ------------------------------------------------------------------------------------

        button.setOnClickListener {
            Log.d("리스너", "클릭되었습니다.") // 이건 바로 클릭하면 실행할 수 있도록 구현
        }

    }
}