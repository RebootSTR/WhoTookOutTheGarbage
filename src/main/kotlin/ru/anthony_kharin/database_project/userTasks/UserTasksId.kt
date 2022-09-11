package ru.anthony_kharin.database_project.userTasks

import java.io.Serializable

data class UserTasksId(
    val userId: String = "",
    val taskId: Int = 0
): Serializable