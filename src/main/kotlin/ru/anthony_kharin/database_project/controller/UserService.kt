package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun create(userEntity: UserEntity) = userRepository.save(userEntity)

    fun readAll(): List<String?> = userRepository.findAll().toList().map { it.firstName }
}