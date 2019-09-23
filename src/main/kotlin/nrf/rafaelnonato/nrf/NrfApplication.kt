package nrf.rafaelnonato.nrf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NrfApplication

fun main(args: Array<String>) {
	runApplication<NrfApplication>(*args)
}
