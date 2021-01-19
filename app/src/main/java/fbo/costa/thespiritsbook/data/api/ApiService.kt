package fbo.costa.thespiritsbook.data.api

import fbo.costa.thespiritsbook.data.model.QueAnsApiEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    //https://www.slideshare.net/MartaMiranda6/22-da-encarnacao-dos-espiritos
    //http://www.dominiopublico.gov.br/download/texto/ph000028.pdf
    companion object {
        const val BASE_URL = "https://livrodosespiritos.herokuapp.com"
    }

    @GET("/get")
    suspend fun getQueAnsList(
    ): Response<List<QueAnsApiEntity>>
}
