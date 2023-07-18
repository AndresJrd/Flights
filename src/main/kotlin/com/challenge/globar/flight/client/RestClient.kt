package com.challenge.globar.flight.client

import com.fasterxml.jackson.core.type.TypeReference

interface RestClient {

    fun <T> executeRequest(uri: String, typeReference: TypeReference<List<T>>): List<T>
}