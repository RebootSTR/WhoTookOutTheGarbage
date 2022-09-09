package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RoomService @Autowired constructor(
    private val roomService: RoomRepository
) {
    fun create(string: String) = roomService.save(string)
    fun readAll(): List<String?> = roomService.read()
}