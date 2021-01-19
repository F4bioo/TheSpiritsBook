package fbo.costa.thespiritsbook.repository

import fbo.costa.thespiritsbook.data.model.QueAns

interface MainRepository {

    suspend fun insertList(queAnsList: ArrayList<QueAns>)

    suspend fun queAnsList(): ArrayList<QueAns>

    suspend fun deleteList()

}
