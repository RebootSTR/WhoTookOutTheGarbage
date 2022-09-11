package com.esg.garbage.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.esg.garbage.task.TaskRepository
import com.esg.garbage.taskStatuses.Statuses
import com.esg.garbage.user.dto.TaskAndUserDTO
import com.esg.garbage.user.dto.AddUserDto
import com.esg.garbage.userTasks.UserTasksEntity
import com.esg.garbage.userTasks.UserTasksId
import com.esg.garbage.userTasks.UserTasksRepository

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository,
    private val taskRepository: TaskRepository,
    private val userTasksRepository: UserTasksRepository
) {
    fun create(dto: AddUserDto): UserEntity {
        val user = UserEntity(
            id = dto.uid,
            firstName = dto.firstName,
            lastName = dto.secondName
        )
        return userRepository.save(user)
    }

    fun read(uid: String): UserEntity = userRepository.findById(uid).get()

    fun readAll(): List<UserEntity> = userRepository.findAll().toList()
    fun addTask(dto: TaskAndUserDTO): UserEntity {
        val user = userRepository.findById(dto.userId).get()
        val task = taskRepository.findById(dto.taskId).get()

        user.tasks.add(task)
        val userResult = userRepository.save(user)

        // change status
        val userTask = userTasksRepository.findById(UserTasksId(user.id, task.id)).get()
        val newUserTask = userTask.copy(
            statusId = Statuses.ACTIVE.id
        )

        // save user and userTask
        userTasksRepository.save(newUserTask)

        return userResult
    }

    fun cancelTask(dto: TaskAndUserDTO): UserTasksEntity {
        // change status
        val userTask = userTasksRepository.findById(UserTasksId(dto.userId, dto.taskId)).get()
        val newUserTask = userTask.copy(
            statusId = Statuses.CANCEL.id
        )

        // save userTask
        return userTasksRepository.save(newUserTask)
    }

    fun getAllUserTasks(userId: String): List<UserTasksEntity> {

        return userTasksRepository.findAllByUserId(userId)
    }
}