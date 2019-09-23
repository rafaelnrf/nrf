package nrf.rafaelnonato.nrf.controller


import nrf.rafaelnonato.nrf.model.Comment
import nrf.rafaelnonato.nrf.model.NewComment
import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
@RequestMapping("comment")
class ComentController {

    // ...
    @PostMapping
    fun createUser(@RequestBody newComment: NewComment): Comment {
        val comment = Comment(
                author = newComment.author,
                content = newComment.content,
                created = Instant.now()
        )
        return comment
    }
}