package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class RoomController @Autowired constructor(
    private val roomService: RoomService
) {

    @PostMapping(value = ["/lol"])
    fun write(string: String): ResponseEntity<String?> {
        roomService.create(string)
        return ResponseEntity("saved", HttpStatus.OK)
    }

    @GetMapping(value = ["/kek"])
    fun read(): ResponseEntity<List<String?>> {
        return ResponseEntity(roomService.readAll(), HttpStatus.OK)
    }

}