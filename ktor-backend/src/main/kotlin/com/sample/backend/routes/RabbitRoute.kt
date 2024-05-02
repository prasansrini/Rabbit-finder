package com.sample.backend.routes

import com.sample.backend.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL: String = "http://192.168.1.180:8080"
private val rabbits = listOf(
	Rabbit("Prasanna", "Rabbit 1", "$BASE_URL/rabbits/rabbit1.jpg"),
	Rabbit("Adi", "Rabbit 2", "$BASE_URL/rabbits/rabbit3.jpg"),
	Rabbit("Shyam", "Rabbit 3", "$BASE_URL/rabbits/rabbit4.jpg"),
	Rabbit("John", "Rabbit 4", "$BASE_URL/rabbits/rabbit5.jpg"),
	Rabbit("Ram", "Rabbit 5", "$BASE_URL/rabbits/rabbit6.jpg"),
	Rabbit("Moni", "Rabbit 6", "$BASE_URL/rabbits/rabbit1.jpg")
)

fun Route.randomRabbit() {
	get("/random/rabbit") {
		call.respond(
			HttpStatusCode.OK,
			rabbits.random()
		)
	}
}

fun Route.nextRabbit() {
	get("/next/rabbit") {
		call.respond(
			HttpStatusCode.OK,
			rabbits.random()
		)
	}
}