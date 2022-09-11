package com.esg.garbage.reports.dto

data class AddReportDto(
    val userId: String,
    val taskId: Int,
    val text: String,
    val photo1: String,
    val photo2: String
)