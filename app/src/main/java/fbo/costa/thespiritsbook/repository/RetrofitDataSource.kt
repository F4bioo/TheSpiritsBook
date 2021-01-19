package fbo.costa.thespiritsbook.repository

import fbo.costa.thespiritsbook.data.api.ApiService
import fbo.costa.thespiritsbook.data.model.QueAns
import fbo.costa.thespiritsbook.data.model.QueAnsApiEntity
import javax.inject.Inject

class RetrofitDataSource
@Inject
constructor(
    private val apiService: ApiService,
) : MainRepository {

    override suspend fun insertList(queAnsList: ArrayList<QueAns>) {
    }

    override suspend fun queAnsList(): ArrayList<QueAns> {
        val response = apiService.getQueAnsList()
        if (response.isSuccessful) {
            val queAnsList = arrayListOf<QueAns>()

            response.body()?.forEach { _queAnsApi ->
                queAnsList.add(_queAnsApi.toQueAns())
            }
            return queAnsList

        } else {
            throw Exception("Unsuccessful response")
        }
    }

    override suspend fun deleteList() {
    }

    // Convert QueAnsApiEntity to QueAns
    private fun QueAnsApiEntity.toQueAns(): QueAns {
        return QueAns(
            id = this.id,
            question = this.question,
            answer = this.answer
        )
    }
}
