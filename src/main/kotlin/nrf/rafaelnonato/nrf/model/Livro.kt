package nrf.rafaelnonato.nrf.model


import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Livro (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val liv_id: Long = 0,

        @get: NotBlank
        val liv_titulo: String = "",

        @get: NotBlank
        val liv_descricao: String = ""
)
