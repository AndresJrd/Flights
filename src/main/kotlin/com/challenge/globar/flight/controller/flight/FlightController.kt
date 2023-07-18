package com.challenge.globar.flight.controller.flight

import com.challenge.globar.flight.dto.FlightDto
import com.challenge.globar.flight.services.flight.FlightsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController("v1.flights")
@RequestMapping("v1/flights")
class FlightController(
    @Qualifier("flightsMockedApi")
    private val flightsMockedApi: FlightsService,

    @Qualifier("flightsApi")
    private val flightsApi: FlightsService,

) {

    @GetMapping("/mocked")
    fun getMockedFlights(): ResponseEntity<List<FlightDto>> {
        return ResponseEntity.ok(flightsMockedApi.getFlights())
    }

    @GetMapping
    fun getFlights(): ResponseEntity<List<FlightDto>> {
        return ResponseEntity.ok(flightsApi.getFlights())
    }

}