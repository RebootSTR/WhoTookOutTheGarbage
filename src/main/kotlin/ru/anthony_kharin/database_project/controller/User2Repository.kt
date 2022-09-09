package ru.anthony_kharin.database_project.controller

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface User2Repository: CrudRepository<UserEntity, Int>