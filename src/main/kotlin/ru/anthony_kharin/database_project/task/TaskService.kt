package ru.anthony_kharin.database_project.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.anthony_kharin.database_project.task.dto.AddTaskDto

@Service
class TaskService @Autowired constructor(
    private val taskRepository: TaskRepository
) {
    fun addTask(dto: AddTaskDto): TaskEntity {
        val task = TaskEntity(
            title = dto.title,
            description = dto.description,
            cost = dto.cost
        )
        return taskRepository.save(task)
    }

    fun getAllTasks() = taskRepository.findAll().toList()
    fun getById(id: Int) = taskRepository.findById(id).get()
}