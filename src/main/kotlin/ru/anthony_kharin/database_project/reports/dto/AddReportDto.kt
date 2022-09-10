package ru.anthony_kharin.database_project.reports.dto

data class AddReportDto(
    val userId: String,
    val taskId: Int,
    val text: String,
    val photo1: String,
    val photo2: String
)