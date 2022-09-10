package ru.anthony_kharin.database_project.user

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

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
    val score: Int = 0
)