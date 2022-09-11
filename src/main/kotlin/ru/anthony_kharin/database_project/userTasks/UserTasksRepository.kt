package ru.anthony_kharin.database_project.userTasks

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserTasksRepository : CrudRepository<UserTasksEntity, UserTasksId>