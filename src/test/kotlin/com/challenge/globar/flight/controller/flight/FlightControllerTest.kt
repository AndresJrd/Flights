package com.challenge.globar.flight.controller.flight


import com.challenge.globar.flight.dto.FlightDto
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class FlightControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper


    @Test
    fun getMockedFlights() {
        // given
        val uri = "/v1/flights/mocked"

        // when
        val result = this.mockMvc.perform(
            MockMvcRequestBuilders.get(uri)
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk)
            .andReturn().response.contentAsString

        // then
        val flights: List<FlightDto> = objectMapper.readValue(result, object : TypeReference<List<FlightDto>>() {})
        assertTrue(flights.isNotEmpty(), "La lista de vuelos no debería estar vacía")
        flights.forEach { flight ->
            assertNotNull(flight.from, "El origen del vuelo no debería ser nulo")
            assertNotNull(flight.to, "El destino del vuelo no debería ser nulo")
            assertNotNull(flight.airline, "La aerolínea del vuelo no debería ser nula")
            assertNotNull(flight.flightNumber, "El número del vuelo no debería ser nulo")
            assertNotNull(flight.departureDateTime, "La fecha de salida del vuelo no debería ser nula")
            assertNotNull(flight.gate, "El número de puerta del vuelo no debería ser nulo")
        }
    }


    @Test
    fun getFlights() {
        // given
        val uri = "/v1/flights"

        // when
        this.mockMvc.perform(
            MockMvcRequestBuilders.get(uri)
        )
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isNotFound)
            .andReturn()
    }
}