package fbo.costa.thespiritsbook.repository

import fbo.costa.thespiritsbook.data.model.QueAns
import javax.inject.Inject

class DataSource
@Inject
constructor(
    private val retrofitDataSource: RetrofitDataSource,
    private val roomDataSource: RoomDataSource
) : MainRepository {

    override suspend fun insertList(queAnsList: ArrayList<QueAns>) {
        roomDataSource.insertList(queAnsList)
    }

    override suspend fun queAnsList(): ArrayList<QueAns> {
        val queAnsRoomList = roomDataSource.queAnsList()

        return if (queAnsRoomList.isNullOrEmpty()) {
            val queAnsApiList = retrofitDataSource.queAnsList()
            insertList(queAnsApiList)
            queAnsApiList // return from Api
        } else {
            queAnsRoomList // return from Database
        }
    }

    override suspend fun deleteList() {
        roomDataSource.deleteList()
    }
}
