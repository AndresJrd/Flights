package com.challenge.globar.flight.services.flight.impl

import com.challenge.globar.flight.dto.FlightDto
import com.challenge.globar.flight.services.flight.FlightsService
import com.github.javafaker.Faker
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

@Component("flightsMockedApi")
class FlightsMockedApi : FlightsService {

    override fun getFlights(): List<FlightDto> {
        val faker = Faker()
        // Genera un número aleatorio entre 10 y 20 para el número de vuelos
        val numberOfFlights = Random.nextInt(10, 20)
        val flights = List(numberOfFlights) {
            FlightDto().apply {
                from = faker.address().cityName()
                to = faker.address().cityName()
                airline = faker.company().name()
                flightNumber = faker.code().asin()
                departureDateTime = LocalDateTime.now().plusMinutes(Random.nextLong(1000, 50000))
                gate = faker.number().numberBetween(1, 100).toString()
            }
        }
        // los agregue para poder usar los filtros ya que siempre estaran
        val customsFlights = mutableListOf(
            FlightDto().apply {
                from = "NYC"
                to = "SEA"
                airline = "United Airlines"
                flightNumber = "1234"
                departureDateTime = LocalDateTime.parse("2019-10-15T20:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                gate = "24"
            },
            FlightDto().apply {
                from = "UAQ"
                to = "AEP"
                airline = "United Airlines"
                flightNumber = "1422"
                departureDateTime = LocalDateTime.parse("2023-07-18T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                gate = "24"
            }
        )

        return flights + customsFlights
    }
}