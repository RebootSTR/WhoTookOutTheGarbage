package ru.anthony_kharin.database_project.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService @Autowired constructor(
    private val taskRepository: TaskRepository
) {

}