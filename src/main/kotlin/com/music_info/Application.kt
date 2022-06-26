package com.music_info

import com.music_info.features.login.configureLoginRouting
import com.music_info.features.register.configureRegisterRouting
import com.music_info.plugins.configureRouting
import com.music_info.plugins.configureSerialization
import io.ktor.server.cio.*
import io.ktor.server.engine.*
import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        "jdbc:postgresql://localhost:5432/postgres", driver = "org.postgresql.Driver",
        user ="postgres", password = ""
    )

    embeddedServer(CIO, port = 8080, host = "0.0.0.0") {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureSerialization()
    }.start(wait = true)
}
