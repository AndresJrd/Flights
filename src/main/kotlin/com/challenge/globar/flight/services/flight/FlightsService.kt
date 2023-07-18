package com.challenge.globar.flight.services.flight

import com.challenge.globar.flight.dto.FlightDto
import java.time.OffsetDateTime

interface FlightsService {

    fun getFlights(): List<FlightDto>

    // igual al default en Java
    fun getFlights(departureDateTime: OffsetDateTime?, airline: String?): List<FlightDto> {
        var allFlights = getFlights()

        departureDateTime?.let {
            val localDateTime = it.toLocalDateTime()
            allFlights = allFlights.filter { flight -> flight.departureDateTime == localDateTime }
        }

        airline?.let {
            allFlights = allFlights.filter { it.airline == airline }
        }
        return allFlights
    }
}