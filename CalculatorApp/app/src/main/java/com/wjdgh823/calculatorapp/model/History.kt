package com.wjdgh823.calculatorapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class History( // 디비테이블을 생성하는 것.
    @PrimaryKey val uid: Int?, // pk 키
    @ColumnInfo(name="expression") val expression: String?,
    @ColumnInfo(name="result") val result: String? // ?추가하면 null 받을 수 있다.
)