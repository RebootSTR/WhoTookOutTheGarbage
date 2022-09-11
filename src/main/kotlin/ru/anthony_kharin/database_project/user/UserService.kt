package ru.anthony_kharin.database_project.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.anthony_kharin.database_project.task.TaskEntity
import ru.anthony_kharin.database_project.task.TaskRepository
import ru.anthony_kharin.database_project.taskStatuses.Statuses
import ru.anthony_kharin.database_project.user.dto.AddTaskToUserDto
import ru.anthony_kharin.database_project.user.dto.AddUserDto
import ru.anthony_kharin.database_project.userTasks.UserTasksId
import ru.anthony_kharin.database_project.userTasks.UserTasksRepository

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
    fun addTask(dto: AddTaskToUserDto): UserEntity {
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

    fun getAllUserTasks(userId: String): List<TaskEntity> {
        val user = userRepository.findById(userId).get()

        return user.tasks
    }
}