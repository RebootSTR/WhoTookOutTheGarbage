package com.esg.garbage.task

import javax.persistence.*

@Entity
@Table(name = "task")
data class TaskEntity(
    @Id
    @SequenceGenerator(name = "taskIdSeq", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "taskIdSeq")
    @Column(name = "id", nullable = false)
    val id: Int = 0,

    @Column(name = "title", nullable = false)
    val title: String = "",

    @Column(name = "description", nullable = false)
    val description: String = "",

    @Column(name = "cost", nullable = false)
    val cost: Int = 0
)