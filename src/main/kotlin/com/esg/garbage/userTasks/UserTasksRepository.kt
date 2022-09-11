package com.esg.garbage.userTasks

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserTasksRepository : CrudRepository<UserTasksEntity, UserTasksId> {

    fun findAllByUserId(userId: String): List<UserTasksEntity>
}