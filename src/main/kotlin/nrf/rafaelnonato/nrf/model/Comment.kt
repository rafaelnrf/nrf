package nrf.rafaelnonato.nrf.model

import java.time.Instant
import com.fasterxml.jackson.annotation.JsonCreator

data class Comment(
        val author: String,
        val content: String,
        val created: Instant
)
// New data class for incoming comments
data class NewComment @JsonCreator constructor(
        val author: String,
        val content: String
)