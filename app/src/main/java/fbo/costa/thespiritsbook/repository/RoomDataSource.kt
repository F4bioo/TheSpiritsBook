package fbo.costa.thespiritsbook.repository

import fbo.costa.thespiritsbook.data.model.QueAns
import fbo.costa.thespiritsbook.data.model.QueAnsRoomEntity
import fbo.costa.thespiritsbook.data.room.QueAnsDao
import javax.inject.Inject

class RoomDataSource
@Inject
constructor(
    private val queAnsDao: QueAnsDao
) : MainRepository {

    override suspend fun insertList(queAnsList: ArrayList<QueAns>) {
        val queAnsRoomList = arrayListOf<QueAnsRoomEntity>()
        queAnsList.forEach { _queAns ->
            queAnsRoomList.add(_queAns.toQueAnsEntity())
        }
        queAnsDao.insert(queAnsRoomList)
    }

    override suspend fun queAnsList(): ArrayList<QueAns> {
        val queAnsList = arrayListOf<QueAns>()
        val queAnsRoomList = queAnsDao.select()
        queAnsRoomList.forEach { _queAnsEntity ->
            queAnsList.add(_queAnsEntity.toQueAns())
        }
        return queAnsList
    }

    override suspend fun deleteList() {
        queAnsDao.delete()
    }

    // Convert QueAns to QueAnsRoomEntity for database INSERT
    private fun QueAns.toQueAnsEntity(): QueAnsRoomEntity {
        return QueAnsRoomEntity(
            id = this.id,
            question = this.question,
            answer = this.answer
        )
    }

    // Convert QueAnsRoomEntity to QueAns for database SELECT
    private fun QueAnsRoomEntity.toQueAns(): QueAns {
        return QueAns(
            id = this.id,
            question = this.question,
            answer = this.answer
        )
    }
}
