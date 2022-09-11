package com.esg.garbage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DatabaseProjectApplication

fun main(args: Array<String>) {
    runApplication<DatabaseProjectApplication>(*args)
}
