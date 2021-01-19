package fbo.costa.thespiritsbook.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fbo.costa.thespiritsbook.data.model.QueAnsRoomEntity

@Dao
interface QueAnsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(queAnsRoomList: List<QueAnsRoomEntity>)

    @Query("SELECT * FROM book")
    suspend fun select(): List<QueAnsRoomEntity>

    @Query("DELETE FROM book")
    suspend fun delete()
}
