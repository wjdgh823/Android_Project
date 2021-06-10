package com.wjdgh823.aoppart02chapter03

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity: AppCompatActivity() {


    private val diaryEditText: EditText by lazy {
        findViewById<EditText>(R.id.diaryEditText)
    }

    private val handler = Handler(Looper.getMainLooper()) //

    override fun onCreate(savedInstanceState: Bundle?) { // 뷰가 다 그려지고
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary) // activity 파일을 등록하고 -> AndroidManifest.xml에 등록해야한다.

        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE) // DiaryActivity가 실행되고 sharedPreference에 저장된 값을
        diaryEditText.setText(detailPreferences.getString("detail", "")) // diaryText에 쀼려준다.
        // detailPreferences에 있는 값중에 detail이라는 이름으로 저장 것을 가져온다.


        val runnable = Runnable { // 멈칫했을때마다 저장되는 기능
            getSharedPreferences("diary", Context.MODE_PRIVATE).edit {
                putString("detail", diaryEditText.text.toString()) // 걍 commit을 false로 주고 저장하는 기능
            }

            Log.d("DiaryActivity", "SAVE!!! ${diaryEditText.text.toString()}")
        }

        // 내용이 수정될떄마다 저장되는 기능을 만든다
        diaryEditText.addTextChangedListener {

            Log.d("DiaryActivity", "TextChanged :: $it")
            handler.removeCallbacks(runnable) // 0.5초 이전에 아직 실행되지 않고 있는 것을 제거하기 위해서
            handler.postDelayed(runnable, 500) // 0.5초에 한번씩 runnable을 실행하는 것이다.
        }

    }
}

/*
    개념 정리
    1. sharedPreference 사용법 -> getSharedPreferences("name: ~ ", Context.MODE_PRIVATE)
                가져오는 법 -> getString으로 저장된 것을 가져올 수 있다.

                저장법 2가지
                commit : ul 스레드를 잠깐 블럭하고 데이터가 다 저장될 때 까지 기다리는
                apply  : 기다리지 않고 비동기적으로 저장하는 기능

    2. noActionBar를 통해 위의 바를 없애는 기능을 구현했다.
    3. AlertDialog.Builder를 통해 alert 기능을 수행할 수 있다.
    4. Handler는 스레드와 스레드간에 통신을 엮어주는 기능


 */