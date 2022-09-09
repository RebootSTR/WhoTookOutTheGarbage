package ru.anthony_kharin.database_project.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Controller class that processes Room requests
 *
 * @author AnthonyKharin
 * [GitHub](https://github.com/AnthonyKharin)
 */
@RestController
class RoomController @Autowired constructor(

) {

    @GetMapping(value = ["/kek"])
    fun read(): ResponseEntity<String?> {
        return ResponseEntity("Sanya loh", HttpStatus.OK)
    }
    

}