package com.challenge.globar.flight.util

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonInclude
import org.springframework.http.HttpStatus
import java.time.LocalDateTime

class ErrorResponse(
    val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
    val message: String? = null,
) {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var errors: MutableList<ApiSubError>? = null
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private val timestamp: LocalDateTime = LocalDateTime.now()
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var debugMessage: String? = null

    fun addValidationError(field: String?, value: String?, message: String?) {
        if (errors == null) {
            errors = ArrayList()
        }
        errors?.add(ApiSubError(field, value, message))
    }


    class ApiSubError(val field: String?, val value: Any?, val message: String?)
}
