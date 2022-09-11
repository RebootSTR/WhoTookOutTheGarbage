package com.esg.garbage.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.esg.garbage.task.dto.AddStatusDto
import com.esg.garbage.task.dto.AddTaskDto
import com.esg.garbage.taskStatuses.StatusService
import com.esg.garbage.taskStatuses.TaskStatusesEntity

@RestController
@RequestMapping("/tasks")
class TaskController @Autowired constructor(
    private val taskService: TaskService,
    private val statusService: StatusService
) {

    @PostMapping(value = ["/new"])
    fun addTask(@RequestBody dto: AddTaskDto): ResponseEntity<TaskEntity> {
        val task = taskService.addTask(dto)
        return ResponseEntity(task, HttpStatus.OK)
    }

    @GetMapping(value = ["/getAll"])
    fun getTasks(): ResponseEntity<List<TaskEntity>> {
        val tasks = taskService.getAllTasks()
        return ResponseEntity(tasks, HttpStatus.OK)
    }

    @GetMapping(value = ["/getById"])
    fun getTaskById(@RequestParam id: Int): ResponseEntity<TaskEntity> {
        val task = taskService.getById(id)
        return ResponseEntity(task, HttpStatus.OK)
    }

    @GetMapping(value = ["/status/getAll"])
    fun getAllStatuses(): ResponseEntity<List<TaskStatusesEntity>> {
        val statuses = statusService.getAll()
        return ResponseEntity(statuses, HttpStatus.OK)
    }

    @PostMapping(value = ["/statuses/new"])
    fun addStatus(@RequestBody dto: AddStatusDto): ResponseEntity<TaskStatusesEntity> {
        val status = statusService.addStatus(dto)
        ResponseEntity(status, HttpStatus.OK)
        return ResponseEntity(HttpStatus.BAD_REQUEST)
    }

    @PostMapping(value = ["/statuses/update"])
    fun addStatus(@RequestBody status: TaskStatusesEntity): ResponseEntity<TaskStatusesEntity> {
        val statusUpdated = statusService.update(status)
        return ResponseEntity(statusUpdated, HttpStatus.OK)
    }
}