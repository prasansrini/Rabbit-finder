package com.sample.backend.plugins

import com.sample.backend.routes.nextRabbit
import com.sample.backend.routes.randomRabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		get("/") {
			call.respond(
				HttpStatusCode.OK,
				"Hello World!"
			)
		}

		randomRabbit()
		nextRabbit()

		// Static plugin. Try to access `/static/index.html`
		static {
			resources("static")
		}
	}
}
