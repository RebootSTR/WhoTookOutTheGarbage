package ru.anthony_kharin.database_project.task

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : CrudRepository<TaskEntity, Int>