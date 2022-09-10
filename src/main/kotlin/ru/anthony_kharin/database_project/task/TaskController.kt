package ru.anthony_kharin.database_project.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TaskController @Autowired constructor(
    private val taskService: TaskService
) {

    @GetMapping(value = ["/tasks"])
    fun read(): ResponseEntity<String> {
        return try {
            ResponseEntity(taskService.readAll().toString(), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

}