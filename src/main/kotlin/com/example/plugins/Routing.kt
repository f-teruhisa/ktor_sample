package com.example.plugins

import com.example.controller.*
import com.example.routes.*
import com.example.models.*
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        
        static("/static") {
            resources("files")
        }
        
        get("/index") {
            val sampleUser = User(1, "John")
            call.respond(FreeMarkerContent("index.ftl", mapOf("user" to sampleUser)))
        }
    }
    routing {
        articleController()
        userController()
        customerRouting()
    }
}

