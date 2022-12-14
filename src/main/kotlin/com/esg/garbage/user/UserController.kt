package com.esg.garbage.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.esg.garbage.user.dto.AddUserDto
import com.esg.garbage.user.dto.TaskAndUserDTO
import com.esg.garbage.userTasks.UserTasksEntity

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping(value = ["/new"])
    fun add(@RequestBody dto: AddUserDto): ResponseEntity<UserEntity> {
        val user = userService.create(dto)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @GetMapping(value = ["/getAll"])
    fun getAll(): ResponseEntity<List<UserEntity>> {
        return ResponseEntity(userService.readAll(), HttpStatus.OK)
    }

    @GetMapping(value = ["/getById"])
    fun getById(@RequestParam uid: String): ResponseEntity<UserEntity> {
        return ResponseEntity(userService.read(uid), HttpStatus.OK)
    }

    @GetMapping(value = ["/tasks/getAll"])
    fun getAllUserTasks(@RequestParam userId: String): ResponseEntity<List<UserTasksEntity>> {
        return ResponseEntity(userService.getAllUserTasks(userId), HttpStatus.OK)
    }

    @PostMapping(value = ["/tasks/new"])
    fun addTask(@RequestBody dto: TaskAndUserDTO): ResponseEntity<UserEntity> {
        val user = userService.addTask(dto)
        return ResponseEntity(user, HttpStatus.OK)
    }

    @PostMapping(value = ["/tasks/cancel"])
    fun cancelTask(@RequestBody dto: TaskAndUserDTO): ResponseEntity<UserTasksEntity> {
        val userTask = userService.cancelTask(dto)
        return ResponseEntity(userTask, HttpStatus.OK)
    }
}