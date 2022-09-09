package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val user2Repository: User2Repository
) {
    fun create(userEntity: UserEntity) = user2Repository.save(userEntity)

    fun readAll(): List<String?> = user2Repository.findAll().map { it.firstname }
}