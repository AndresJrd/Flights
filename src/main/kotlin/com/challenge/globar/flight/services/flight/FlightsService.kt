package com.challenge.globar.flight.services.flight

import com.challenge.globar.flight.dto.FlightDto

interface FlightsService {

    fun getFlights(): List<FlightDto>
}