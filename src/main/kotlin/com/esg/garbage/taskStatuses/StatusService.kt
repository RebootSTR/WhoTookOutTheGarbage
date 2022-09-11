package com.esg.garbage.taskStatuses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.esg.garbage.task.dto.AddStatusDto

@Service
class StatusService @Autowired constructor(
    private val statusRepository: StatusRepository
) {
    fun addStatus(dto: AddStatusDto): TaskStatusesEntity {
        val status = TaskStatusesEntity(
            name = dto.name
        )
        return statusRepository.save(status)
    }

    fun getAll() = statusRepository.findAll().toList()
    fun update(status: TaskStatusesEntity): TaskStatusesEntity {
        return statusRepository.save(status)
    }
}