package fbo.costa.thespiritsbook.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book")
data class QueAnsRoomEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val _id: Long = 0,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "question")
    val question: String,
    @ColumnInfo(name = "answer")
    val answer: String
)
