package com.wjdgh823.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 데이터 로딩
        val data = loadData()
        // 2. 어탭터 생성
        val adapter = CustomAdapter()
        // 3. 어댑터에 데이터 전달
        adapter.listData = data
        // 4. 화면에 있는 리사이클러에 있는 어답터 연결
        recycler.adapter = adapter
        // 5. 레이아웃 매니저 연결
        recycler.layoutManager = LinearLayoutManager(this)

    }

    fun loadData() : MutableList<Memo> {
        val data:MutableList<Memo> = mutableListOf()

        for(no in 1..100) {
            val title = "이것이 안드로이드다 ${no}"
            val date = System.currentTimeMillis()

            val memo = Memo(no, title, date) // class에 값이 입력되면서 들어갈 것이다.
            data.add(memo)
        }

        return data
    }

}

