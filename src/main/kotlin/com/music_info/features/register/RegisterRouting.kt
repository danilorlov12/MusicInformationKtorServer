package com.music_info.features.register

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configureRegisterRouting() {

    routing {
        post("/register"){
            val registerController = RegisterController()
            registerController.registerNewUser(call)
        }
    }
}