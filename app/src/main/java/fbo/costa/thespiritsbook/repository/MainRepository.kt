package fbo.costa.thespiritsbook.repository

import fbo.costa.thespiritsbook.data.model.QueAns

interface MainRepository {

    suspend fun queAnsList(): ArrayList<QueAns>

}
