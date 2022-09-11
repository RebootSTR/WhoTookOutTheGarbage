package ru.anthony_kharin.database_project.userTasks

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "user_tasks")
@IdClass(value = UserTasksId::class)
data class UserTasksEntity(

    @Id
    @Column(name = "user_id", nullable = false)
    val userId: String = "",

    @Id
    @Column(name = "task_id", nullable = false)
    val taskId: Int = 0,

    @Column(name = "status_id", nullable = true)
    val statusId: Int? = 0,

    @Column(name = "report_id", nullable = true)
    val reportId: Int? = null
) : Serializable