package com.example.controller

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.userController() {
    route("/user") {
        get {
            call.respondText { "user routing ok" }
        }
        get("/detail") {
            call.respond(HttpStatusCode.OK, "user detail routing ok")
        }
    }
}