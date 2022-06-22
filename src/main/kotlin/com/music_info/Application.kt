package com.music_info

import io.ktor.server.engine.*
import io.ktor.server.cio.*
import com.music_info.plugins.*

fun main() {
    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureSerialization()
    }.start(wait = true)
}
