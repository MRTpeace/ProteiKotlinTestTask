package com.test_task.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.test_task.plugins.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}

fun Application.configureCoding() {
    routing {
        get("/encode/{method}/{data}") {
            val method = call.parameters["method"]
            val data = call.parameters["data"] ?: ""
            val encodedData = when (method) {
                "md5" -> data.toMD5()
                "sha1" -> data.toSHA1()
                "sha256" -> data.toSHA256()
                else -> "Unknown method"
            }
            call.respond(encodedData)
        }
    }
}
