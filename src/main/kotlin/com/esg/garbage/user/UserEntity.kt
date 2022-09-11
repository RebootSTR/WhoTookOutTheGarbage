package com.esg.garbage.user

import com.esg.garbage.task.TaskEntity
import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @Column(name = "id")
    val id: String = "",

    @Column(name = "first_name")
    val firstName: String = "",

    @Column(name = "last_name")
    val lastName: String = "",

    @Column(name = "score")
    val score: Int = 0,

    @ManyToMany(cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "user_tasks",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "task_id")]
    )
    val tasks: MutableList<TaskEntity> = mutableListOf()
)