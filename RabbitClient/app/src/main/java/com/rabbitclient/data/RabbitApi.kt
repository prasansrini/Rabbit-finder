package com.rabbitclient.data

import com.sample.backend.model.Rabbit
import retrofit2.http.GET

interface RabbitApi {
	@GET("/random/rabbit")
	suspend fun getRandomRabbit(): Rabbit

	companion object {
		const val BASE_URL = "http://192.168.1.180:8080"
	}
}