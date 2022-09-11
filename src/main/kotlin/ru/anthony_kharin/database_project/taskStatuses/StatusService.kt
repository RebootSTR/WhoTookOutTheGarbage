package ru.anthony_kharin.database_project.taskStatuses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.anthony_kharin.database_project.task.dto.AddStatusDto

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