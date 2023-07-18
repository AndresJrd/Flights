package com.challenge.globar.flight.services.flight.impl

import com.challenge.globar.flight.dto.FlightDto
import com.challenge.globar.flight.services.flight.FlightsService
import com.github.javafaker.Faker
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import kotlin.random.Random

@Component("flightsMockedApi")
class FlightsMockedApi : FlightsService {

    override fun getFlights(): List<FlightDto> {
        val faker = Faker()
        // Genera un número aleatorio entre 10 y 20 para el número de vuelos
        val numberOfFlights = Random.nextInt(10, 20)
        return List(numberOfFlights) {
            FlightDto().apply {
                from = faker.address().cityName()
                to = faker.address().cityName()
                airline = faker.company().name()
                flightNumber = faker.code().asin()
                departureDateTime = LocalDateTime.now().plusMinutes(Random.nextLong(1000, 50000))
                gate = faker.number().numberBetween(1, 100).toString()
            }
        }
    }
}