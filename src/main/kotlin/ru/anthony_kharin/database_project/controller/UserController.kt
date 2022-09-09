package ru.anthony_kharin.database_project.controller

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
    fun read(): ResponseEntity<List<String?>> {
        return try {
            val users = userService.readAll()
            ResponseEntity(users, HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(listOf( t.message), HttpStatus.BAD_REQUEST)
        }
    }

}