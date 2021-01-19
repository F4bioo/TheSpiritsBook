package fbo.costa.thespiritsbook.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class QueAnsApiEntity(
    @SerializedName("Id")
    @Expose
    val id: String,
    @SerializedName("Pergunta")
    @Expose
    val question: String,
    @SerializedName("Resposta")
    @Expose
    val answer: String
)
