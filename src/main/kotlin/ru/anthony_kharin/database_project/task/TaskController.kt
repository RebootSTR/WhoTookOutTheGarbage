package ru.anthony_kharin.database_project.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TaskController @Autowired constructor(
    private val userService: TaskService
) {

    @PostMapping(value = ["/register"])
    @ResponseBody
    fun write(userEntity: TaskEntity): ResponseEntity<String> {
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
            ResponseEntity(userService.readAll().toString(), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

}