package ru.anthony_kharin.database_project.taskStatuses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StatusService @Autowired constructor(
    private val statusRepository: StatusRepository
) {
    fun addStatus(name: String): TaskStatusesEntity {
        val status = TaskStatusesEntity(
            name = name
        )
        return statusRepository.save(status)
    }
}