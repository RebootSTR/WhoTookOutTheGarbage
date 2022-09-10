package ru.anthony_kharin.database_project.controller

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping(value = ["/register"])
    @ResponseBody
    fun write(userEntity: UserEntity): ResponseEntity<String> {
        try {
            userService.create(userEntity)
        } catch (t: Throwable) {
            return ResponseEntity(t.message, HttpStatus.BAD_REQUEST)
        }
        return ResponseEntity("Completed", HttpStatus.OK)
    }

    @GetMapping(value = ["/users"])
    fun read(): ResponseEntity<String> {
        return try {
            val users = userService.readAll()
            ResponseEntity(Gson().toJson(users), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

}