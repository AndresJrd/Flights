package com.challenge.globar.flight.controller.flight

import com.challenge.globar.flight.dto.FlightDto
import com.challenge.globar.flight.services.flight.FlightsService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime

@RestController("v1.flights")
@RequestMapping("v1/flights")
class FlightController(
    @Qualifier("flightsMockedApi")
    private val flightsMockedApi: FlightsService,

    @Qualifier("flightsApi")
    private val flightsApi: FlightsService,

) {

    @GetMapping("/mocked")
    fun getMockedFlights(
        @RequestParam("departureDateTime", required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        departureDateTime: OffsetDateTime?,
        @RequestParam("airline", required = false) airline: String?
    ): ResponseEntity<List<FlightDto>> {
        return ResponseEntity.ok(flightsMockedApi.getFlights(departureDateTime, airline))
    }

    @GetMapping
    fun getFlights(
        @RequestParam("departureDateTime", required = false)
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        departureDateTime: OffsetDateTime?,
        @RequestParam("airline", required = false) airline: String?): ResponseEntity<List<FlightDto>> {
        return ResponseEntity.ok(flightsApi.getFlights(departureDateTime, airline))
    }

}