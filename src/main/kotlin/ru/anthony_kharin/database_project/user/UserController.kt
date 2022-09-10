package ru.anthony_kharin.database_project.user

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
    fun readAll(): ResponseEntity<String> {
        return try {
            ResponseEntity(userService.readAll().toString(), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/users"])
    fun read(@RequestParam uid: String): ResponseEntity<UserEntity> {
        return try {
            ResponseEntity(userService.read(uid), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

}