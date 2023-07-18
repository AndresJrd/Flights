package com.challenge.globar.flight.client.impl

import com.challenge.globar.flight.client.RestClient
import com.challenge.globar.flight.exceptions.ResourceNotFoundException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class RestClientImpl(
    private val objectMapper: ObjectMapper
) :RestClient {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun <T> executeRequest(uri: String, typeReference: TypeReference<List<T>>): List<T> {
        val httpClient: CloseableHttpClient = HttpClients.createDefault()
        val request = HttpGet(uri).apply {
            addHeader("Accept", "application/json")
        }

        httpClient.execute(request).use { response ->
            if (response.statusLine.statusCode != 200) {
                log.error("Error executing restCall on $uri error:${response.statusLine.statusCode}")
                throw ResourceNotFoundException("Failed: HTTP error code: ${response.statusLine.statusCode}")
            }

            val entity = response.entity ?: throw RuntimeException("No response from server")

            val result = EntityUtils.toString(entity)

            return objectMapper.readValue(result, typeReference)
        }
    }

}