package ru.anthony_kharin.database_project.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.anthony_kharin.database_project.task.TaskEntity
import ru.anthony_kharin.database_project.user.dto.AddTaskToUserDto
import ru.anthony_kharin.database_project.user.dto.AddUserDto

@RestController
@RequestMapping("/users")
class UserController @Autowired constructor(
    private val userService: UserService
) {

    @PostMapping(value = ["/new"])
    fun add(dto: AddUserDto): ResponseEntity<UserEntity> {
        return try {
            val user = userService.create(dto)
            ResponseEntity(user, HttpStatus.OK)
        } catch (t: Throwable) {
            return ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/getAll"])
    fun getAll(): ResponseEntity<List<UserEntity>> {
        return try {
            ResponseEntity(userService.readAll(), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/getById"])
    fun getById(@RequestParam uid: String): ResponseEntity<UserEntity> {
        return try {
            ResponseEntity(userService.read(uid), HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/tasks/getAll"])
    fun getAllUserTasks(@RequestParam userId: String): ResponseEntity<List<TaskEntity>> {
        return ResponseEntity(userService.getAllUserTasks(userId), HttpStatus.OK)
    }

    @PostMapping(value = ["/tasks/new"])
    fun addTask(dto: AddTaskToUserDto): ResponseEntity<UserEntity> {
        val user = userService.addTask(dto)
        return ResponseEntity(user, HttpStatus.OK)
    }
}