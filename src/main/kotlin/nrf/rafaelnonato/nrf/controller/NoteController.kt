package nrf.rafaelnonato.nrf.controller


import nrf.rafaelnonato.nrf.model.Note
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import jdk.nashorn.internal.objects.NativeArray.forEach
import org.springframework.web.bind.annotation.RequestHeader
import javax.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Autowired







@Controller
@RequestMapping("notes")
class NoteController {

    @Autowired
    private val sender: JavaMailSender? = null

    @GetMapping
    @ResponseBody
    fun list(): List<Note> {

        //@RequestParam String id
        //@RequestParam Map<String,String> allParams
        return listOf(Note("Leitura", "Livro de Spring Boot"),
                Note("Pesquisa", "Ambiente com Docker"))
    }

    @GetMapping("/listHeaders")
    fun listAllHeaders(@RequestHeader headers: Map<String, String>): ResponseEntity<String> {
        headers.forEach { (key, value) -> print(String.format("Header '%s' = %s", key, value)) }
        //sendEmail()
        return ResponseEntity(String.format("Listed %d headers", headers.size), HttpStatus.OK)
    }

    @Throws(Exception::class)
    private fun sendEmail() {
        val message = sender?.createMimeMessage()
        val helper = message?.let { MimeMessageHelper(it) }

        helper?.setTo("rafaelnrf2007@yahoo.com.br")
        helper?.setText("How are you?")
        helper?.setSubject("Hi")

        sender?.send(message)
    }


}