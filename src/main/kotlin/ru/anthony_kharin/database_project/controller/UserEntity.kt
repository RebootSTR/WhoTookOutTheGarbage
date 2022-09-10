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
    @Column(name = "firstname")
    val firstname: String? = null,
    @Column(name = "secondname")
    val secondname: String? = null,
    @Column(name = "score")
    val score: Int? = null
)