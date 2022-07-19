package com.music_info.features.login

import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.post
import io.ktor.server.routing.routing

fun Application.configureLoginRouting() {

    routing {
        post("/login"){
            val loginController = LoginController()
            loginController.performLogin(call)
        }
    }
}