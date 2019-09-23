package nrf.rafaelnonato.nrf.repository

import nrf.rafaelnonato.nrf.model.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository : JpaRepository<Livro, Long>