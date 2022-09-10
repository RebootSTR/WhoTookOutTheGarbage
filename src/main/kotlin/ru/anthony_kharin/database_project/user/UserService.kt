package ru.anthony_kharin.database_project.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.anthony_kharin.database_project.user.dto.AddUserDto

@Service
class UserService @Autowired constructor(
    private val userRepository: UserRepository
) {
    fun create(dto: AddUserDto): UserEntity {
        val user = UserEntity(
            id = dto.uid,
            firstName = dto.firstName,
            lastName = dto.secondName
        )
        return userRepository.save(user)
    }

    fun read(uid: String): UserEntity = userRepository.findById(uid).get()

    fun readAll(): List<UserEntity> = userRepository.findAll().toList()
}