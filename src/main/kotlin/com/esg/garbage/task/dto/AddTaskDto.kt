package com.esg.garbage.task.dto

data class AddTaskDto(
    val title: String,
    val description: String,
    val cost: Int
)