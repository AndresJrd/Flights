package com.challenge.globar.flight.services.flight.impl

import com.challenge.globar.flight.client.impl.RestClientImpl
import com.challenge.globar.flight.dto.FlightDto
import com.challenge.globar.flight.services.flight.FlightsService
import com.fasterxml.jackson.core.type.TypeReference
import org.springframework.stereotype.Component

@Component("flightsApi")
class FlightsApi(
    private val restClientImpl: RestClientImpl
) : FlightsService {
    override fun getFlights(): List<FlightDto> {
        return restClientImpl.executeRequest(
            "http://demo0656547.mockable.io/flights",
            object : TypeReference<List<FlightDto>>() {})
    }
}