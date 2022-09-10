package ru.anthony_kharin.database_project.task.dto

data class AddTaskDto(
    val title: String,
    val description: String,
    val cost: Int
)