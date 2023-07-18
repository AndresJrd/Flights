package com.challenge.globar.flight.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

class FlightDto {
    var from: String ? = null
    var to: String ? = null
    var airline: String ? = null
    var flightNumber: String ? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonProperty("departure_datetime")
    var departureDateTime: LocalDateTime? = null
    var gate: String ? = null
}