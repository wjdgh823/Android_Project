package com.wjdgh823.aoppart02chapter03

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {

    private val numberPicker1: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker1)
            .apply{ // 최대값, 최소값을 설정하기 위해서는 .apply를 통해서 초기화한다.
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker2: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker2)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }
    private val numberPicker3: NumberPicker by lazy {
        findViewById<NumberPicker>(R.id.numberPicker3)
            .apply{
                minValue = 0
                maxValue = 9
            }
    }

    private val openButton: AppCompatButton by lazy { // 버튼에 대한 초기화설정
        findViewById<AppCompatButton>(R.id.openButton)
    }

    private val changePasswordButton: AppCompatButton by lazy { // 버튼에 대한 초기화설정
        findViewById<AppCompatButton>(R.id.changePasswordButton)
    }

    // 내가 예상했던 결과와 다른 결과가 나타날 수 있기 때문에 상황에 따라 처리할 수 있도록 설정
    private var changePasswordMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker1 // 호출해야 사용할 수 있다.
        numberPicker2
        numberPicker3

        openButton.setOnClickListener {

            if (changePasswordMode) {
                Toast.makeText(this, "비밀번호 변경 중입니다.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE) // 다른앱과 사용하기 위해 공유하는 것이다.
            // 파일을 저장할 이름 "name", 우리앱에서만 사용할 수 있는 모드 "Context.MODE_PRIVATE"
            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"
            // 입력된 값을 나열방식으로 저장하는 방법 ex) 111 / 123 / 234

            if (passwordPreferences.getString("password", "000").equals(passwordFromUser)) { // getString을 통해 저장된 password을 가져올 수 있다.
                // 패스워드 성공
                // TODO 다이어리 페이지 작성 후에 남겨주어야 한다.
                startActivity(Intent(this, DiaryActivity::class.java)) // 다이어리 페이지를 생성하는 함수 -> Intent를 통해 activity간에 다음으로 넘어가는 코드
            } else {
                showErrorAlertDialog()
            }

        }

        // 비밀번호를 바꾸는 기능
        changePasswordButton.setOnClickListener {
            // changePasswordMode가 활성화 :: 비밀번호가 맞는지 체크
            val passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE)
            // 파일을 저장할 이름 "name", 우리앱에서만 사용할 수 있는 모드 "Context.MODE_PRIVATE"
            val passwordFromUser = "${numberPicker1.value}${numberPicker2.value}${numberPicker3.value}"

            if (changePasswordMode) {
                // 번호를 저장하는 기능
                passwordPreferences.edit(true){ // ???????????
                    putString("password", passwordFromUser)
                }

                changePasswordMode = false // 저장이 끝났기 때문에 모드를 false로 변경한다.
                changePasswordButton.setBackgroundColor(Color.BLACK) // 변경이 완료되었으니 변경버튼을 블랙으로 변경
            } else {

                if (passwordPreferences.getString("password", "000").equals(passwordFromUser)) { // getString을 통해 저장된 password을 가져올 수 있다.
                    changePasswordMode = true
                    Toast.makeText(this, "변경할 패스워드를 입력해주세요.", Toast.LENGTH_SHORT).show()
                    changePasswordButton.setBackgroundColor(Color.RED) // 변경모드로 바꾸기 위해서 버튼 색상을 바꾼다.
                } else {
                    showErrorAlertDialog() // 에러 부분을 함수로 빌드해서 호출한다.
                }
            }

        }

    }

    private fun showErrorAlertDialog() {
        AlertDialog.Builder(this) // alert이라고 보면 된다.
            .setTitle("실패!") // 제목
            .setMessage("비밀번호가 잘못되었습니다.") // 내용
            .setPositiveButton("확인") { _, _ -> } // 버튼 누르는 것
            .create() // 만들고
            .show() // 보여줘라
    }
}