package fbo.costa.thespiritsbook.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import fbo.costa.thespiritsbook.data.model.QueAnsRoomEntity

@Database(entities = [QueAnsRoomEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun queAnsDao(): QueAnsDao

    companion object {
        var DATABASE_NAME: String = "book.db"
    }
}
