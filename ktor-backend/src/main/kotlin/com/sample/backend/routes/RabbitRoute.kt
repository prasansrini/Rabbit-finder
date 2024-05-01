package com.sample.backend.routes

import com.sample.backend.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL: String = "http://192.168.1.180:8080"
private val rabbits = listOf(
	Rabbit("Prasanna", "New rabbit", ""),
	Rabbit("Adi", "New rabbit", ""),
	Rabbit("Shyam", "New rabbit", ""),
	Rabbit("John", "New rabbit", ""),
	Rabbit("Ram", "New rabbit", ""),
	Rabbit("Moni", "New rabbit", "")
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