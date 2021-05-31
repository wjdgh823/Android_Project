package com.wjdgh823.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_SUB = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java) // 버튼을 눌렀을때 반응할 activity 선택
            intent.putExtra("param", "실제값") // intent 안에 putExtra로 값을 담아준다.
            startActivityForResult(intent, REQ_SUB)  // 액티비티에 담아준다.
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            when(REQ_SUB) {
                99 -> {
                    val returnValue = data?.getStringExtra("param2") ?: "None"
                    Log.d("액티비티", "돌려받은 값=$returnValue")
                }
            }

        }

    }
}