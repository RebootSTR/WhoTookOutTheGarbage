package ru.anthony_kharin.database_project.task

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "task")
data class TaskEntity(
    @Id
    @Column(name = "id")
    val id: Int = 0,
    @Column(name = "cost")
    val cost: String = "",
    @Column(name = "text")
    val text: String = ""
)