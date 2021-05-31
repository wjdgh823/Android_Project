package com.wjdgh823.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val param = intent.getStringExtra("param")  // 값을 꺼낸다.
        Log.d("액티비티", "param=$param")

        btnReturn.setOnClickListener {
            val intent = Intent() // 값을 다시 돌리기 위해서 사용( Intent() )
            intent.putExtra("param2", "돌려드립니다.")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}