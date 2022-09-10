package ru.anthony_kharin.database_project.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun create(userEntity: UserEntity) = userRepository.save(userEntity)

    fun read(uid: String): UserEntity? = userRepository.findById(uid).get()

    fun readAll(): List<UserEntity?> = userRepository.findAll().toList()
}