package com.challenge.globar.flight.services.flight

import com.challenge.globar.flight.client.impl.RestClientImpl
import com.challenge.globar.flight.dto.FlightDto
import com.challenge.globar.flight.services.flight.impl.FlightsApi
import com.fasterxml.jackson.core.type.TypeReference
import com.github.javafaker.Faker
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.random.Random

class FlightsServiceTest {

    private val faker = Faker()

    @Test
    fun getFlightsTest() {
        // given
        val restClientImpl = mockk<RestClientImpl>()
        val flightsApi = FlightsApi(restClientImpl)

        val mockFlights: List<FlightDto> = listOf(
            FlightDto().apply {
                from = faker.address().cityName()
                to = faker.address().cityName()
                airline = faker.company().name()
                flightNumber = faker.code().asin()
                departureDateTime = LocalDateTime.now().plusMinutes(Random.nextLong(1000, 50000))
                gate = faker.number().numberBetween(1, 100).toString()
            }
        )

        every {
            restClientImpl.executeRequest(
                "http://demo0656547.mockable.io/flights",
                ofType<TypeReference<List<FlightDto>>>())
        } returns mockFlights

        // when
        val result = flightsApi.getFlights()

        // then
        assertEquals(mockFlights, result)
    }
}