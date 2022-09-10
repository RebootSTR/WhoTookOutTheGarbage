package ru.anthony_kharin.database_project.taskStatuses

import javax.persistence.*

@Entity
@Table(name = "task_statuses")
data class TaskStatusesEntity(

    @Id
    @SequenceGenerator(name = "taskStatusesIdSeq", sequenceName = "task_statuses_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_statusesIdSeq")
    @Column(name = "id", nullable = false)
    val id: Int = 0,

    @Column(name = "name", nullable = false)
    val name: String = ""
)