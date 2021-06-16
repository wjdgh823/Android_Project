package com.wjdgh823.calculatorapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wjdgh823.calculatorapp.dao.HistoryDao
import com.wjdgh823.calculatorapp.model.History

/** 데이터 베이스를 선언한다. **/
@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao // 데이터베이스에 historyDao를 선언해서 설정했다.
}