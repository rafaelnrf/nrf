package nrf.rafaelnonato.nrf.controller


import nrf.rafaelnonato.nrf.model.Livro
import nrf.rafaelnonato.nrf.repository.LivroRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LivroController(private val livroRepository: LivroRepository) {

    @GetMapping("/livros")
    fun getAllArticles(): List<Livro> =
            livroRepository.findAll()


    @PostMapping("/livros")
    fun createNewArticle(@Valid @RequestBody livro: Livro): Livro =
            livroRepository.save(livro)


    @GetMapping("/livros/{id}")
    fun getArticleById(@PathVariable(value = "id") articleId: Long): ResponseEntity<Livro> {
        return livroRepository.findById(articleId).map { Livro ->
            ResponseEntity.ok(Livro)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/livros/{id}")
    fun updateArticleById(@PathVariable(value = "id") articleId: Long,
                          @Valid @RequestBody newLivro: Livro): ResponseEntity<Livro> {

        return livroRepository.findById(articleId).map { existingArticle ->
            val updatedArticle: Livro = existingArticle
                    .copy(liv_titulo  = newLivro.liv_titulo, liv_descricao = newLivro.liv_descricao)
            ResponseEntity.ok().body(livroRepository.save(updatedArticle))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/livros/{id}")
    fun deleteArticleById(@PathVariable(value = "id") livroId: Long): ResponseEntity<Void> {

        return livroRepository.findById(livroId).map { article  ->
            livroRepository.delete(article)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}
