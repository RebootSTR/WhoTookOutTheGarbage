package com.esg.garbage.config

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(Exception::class)
    fun handleException(e: Exception): ResponseEntity<ErrorResponse> {
        val stacktrace = e.stackTrace.map { it.toString() }

        return ResponseEntity(
            ErrorResponse(
                status = 500,
                stacktrace = stacktrace,
                error = e.toString()
            ),
            HttpStatus.resolve(500)!!
        )
    }
}

data class ErrorResponse(
    val status: Int,
    val error: String,
    val stacktrace: List<String>
)