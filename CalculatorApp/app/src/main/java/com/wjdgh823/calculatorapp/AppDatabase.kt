package com.wjdgh823.calculatorapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wjdgh823.calculatorapp.dao.HistoryDao
import com.wjdgh823.calculatorapp.model.History

@Database(entities = [History::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}