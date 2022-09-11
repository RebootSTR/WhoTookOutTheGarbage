package ru.anthony_kharin.database_project.user.dto

data class AddTaskToUserDto(
    val userId: String,
    val taskId: Int
)