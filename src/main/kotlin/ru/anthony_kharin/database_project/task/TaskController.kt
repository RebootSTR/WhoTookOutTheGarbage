package ru.anthony_kharin.database_project.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.anthony_kharin.database_project.task.dto.AddStatusDto
import ru.anthony_kharin.database_project.task.dto.AddTaskDto
import ru.anthony_kharin.database_project.taskStatuses.StatusService
import ru.anthony_kharin.database_project.taskStatuses.TaskStatusesEntity

@RestController
@RequestMapping("/tasks")
class TaskController @Autowired constructor(
    private val taskService: TaskService,
    private val statusService: StatusService
) {

    @PostMapping(value = ["/new"])
    fun addTask(dto: AddTaskDto): ResponseEntity<TaskEntity> {
        return try {
            val task = taskService.addTask(dto)
            ResponseEntity(task, HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/getAll"])
    fun getTasks(): ResponseEntity<List<TaskEntity>> {
        return try {
            val tasks = taskService.getAllTasks()
            ResponseEntity(tasks, HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/getById"])
    fun getTaskById(@RequestParam id: Int): ResponseEntity<TaskEntity> {
        return try {
            val task = taskService.getById(id)
            ResponseEntity(task, HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @GetMapping(value = ["/status/getAll"])
    fun getAllStatuses(): ResponseEntity<List<TaskStatusesEntity>> {
        val statuses = statusService.getAll()
        return ResponseEntity(statuses, HttpStatus.OK)
    }

    @PostMapping(value = ["/statuses/new"])
    fun addStatus(dto: AddStatusDto): ResponseEntity<TaskStatusesEntity> {
        return try {
            val status = statusService.addStatus(dto)
            ResponseEntity(status, HttpStatus.OK)
        } catch (t: Throwable) {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }

    @PostMapping(value = ["/statuses/update"])
    fun addStatus(status: TaskStatusesEntity): ResponseEntity<TaskStatusesEntity> {
        val status = statusService.update(status)
        return ResponseEntity(status, HttpStatus.OK)
    }
}