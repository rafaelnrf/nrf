package nrf.rafaelnonato.nrf.controller

import nrf.rafaelnonato.nrf.dao.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import nrf.rafaelnonato.nrf.model.User
import javax.servlet.ServletException
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMethod
import java.util.*


@RestController
@RequestMapping("/users")

class UserController{
    @Autowired
    private lateinit var userService: UserService

    @GetMapping("/me")
    fun me() = ResponseEntity.ok(userService.myself()!!)


}