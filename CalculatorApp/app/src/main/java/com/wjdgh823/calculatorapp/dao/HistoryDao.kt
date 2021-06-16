package com.wjdgh823.calculatorapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.wjdgh823.calculatorapp.model.History

@Dao  // room에 연결된 것을 가져온것이다.
interface HistoryDao {


    // Dao에서 쿼리를 실행할 수 있다.
    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()

    //@Delete // 삭제하고 싶은 것을 받아온것을 history만 delete한다
    //fun delete(history: History)

    //@Query("SELECT * FROM history WHERE result LIKE :result Limit 1") // 앞의 하나만 가져오는 것
    //fun findByResult(result: String): History

}