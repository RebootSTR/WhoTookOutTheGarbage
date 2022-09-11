package ru.anthony_kharin.database_project.taskStatuses

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository : CrudRepository<TaskStatusesEntity, Int>