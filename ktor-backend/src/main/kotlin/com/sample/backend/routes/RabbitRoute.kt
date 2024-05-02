package com.sample.backend.routes

import com.sample.backend.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL: String = "http://192.168.1.180:8080"
private val rabbits = listOf(
	Rabbit("Prasanna", "New rabbit", "$BASE_URL/rabbits/rabbit1.jpg"),
	Rabbit("Adi", "New rabbit", "$BASE_URL/rabbits/rabbit3.jpg"),
	Rabbit("Shyam", "New rabbit", "$BASE_URL/rabbits/rabbit4.jpg"),
	Rabbit("John", "New rabbit", "$BASE_URL/rabbits/rabbit5.jpg"),
	Rabbit("Ram", "New rabbit", "$BASE_URL/rabbits/rabbit6.jpg"),
	Rabbit("Moni", "New rabbit", "$BASE_URL/rabbits/rabbit1.jpg")
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