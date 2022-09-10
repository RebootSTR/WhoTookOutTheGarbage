package ru.anthony_kharin.database_project.ping

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class PingController @Autowired constructor() {

    @GetMapping(value = ["/ping"])
    fun ping(): ResponseEntity<HttpStatus> = ResponseEntity(HttpStatus.OK)

}