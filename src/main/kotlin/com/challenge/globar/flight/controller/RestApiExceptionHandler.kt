package com.challenge.globar.flight.controller

import com.challenge.globar.flight.exceptions.ResourceNotFoundException
import com.challenge.globar.flight.util.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestApiExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handleNotFoundException(ex: ResourceNotFoundException): ResponseEntity<Any> {
        return buildResponseEntity(ErrorResponse(status = HttpStatus.NOT_FOUND, message = ex.message))
    }

    private fun buildResponseEntity(apiError: ErrorResponse): ResponseEntity<Any> {
        return ResponseEntity(apiError, apiError.status)
    }
}