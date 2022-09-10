package ru.anthony_kharin.database_project.controller

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @Column(name = "id")
    val id: Int = 0,
    @Column(name = "first_name")
    val firstName: String? = null,
    @Column(name = "last_name")
    val lastName: String? = null,
    @Column(name = "score")
    val score: Int? = null
)