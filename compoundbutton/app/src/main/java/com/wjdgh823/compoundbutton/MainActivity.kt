package com.wjdgh823.compoundbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        radioGroup.setOnCheckedChangeListener { _, checkedId ->  // 사용하지 않는 것은 _로 표시하자 _은 radioGroup을 의미
            when(checkedId) {
                R.id.radioApple -> Log.d("라디오","사과가 선택되었다.") // radio를 선택하기 위해서는 R.id.아이디값 을 입력한다.
                R.id.radioBanana -> Log.d("라디오","바나나가 선택되었다.")
                R.id.radioOrange -> Log.d("라디오","오렌지지가 선택되었다.")
           }
        }

    }
}