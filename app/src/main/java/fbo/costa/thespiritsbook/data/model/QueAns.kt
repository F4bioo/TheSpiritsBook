package fbo.costa.thespiritsbook.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class QueAns(
    val id: String,
    val question: String,
    val answer: String
) : Parcelable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        if (javaClass != other?.javaClass) return false

        val queAns = other as QueAns
        return id == queAns.id
                && question == queAns.question
                && answer == queAns.answer
    }

    override fun hashCode(): Int {
        return Objects.hash(
            id,
            question,
            answer
        )
    }

    override fun toString(): String {
        return "QueAns(id='$id', question='$question', answer='$answer')"
    }
}
