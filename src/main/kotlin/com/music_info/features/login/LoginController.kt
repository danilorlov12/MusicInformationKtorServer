package com.music_info.features.login

import com.music_info.database.tokens.TokenDTO
import com.music_info.database.tokens.Tokens
import com.music_info.database.users.Users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import java.util.*

class LoginController {

    suspend fun performLogin(call: ApplicationCall) {
        val receive = call.receive<LoginReceiveRemote>()
        val userDTO = Users.fetch(receive.login)

        if (userDTO == null) {
            call.respond(HttpStatusCode.BadRequest, "User isn't exist")
        } else {
            if (userDTO.password == receive.password) {
                val token = UUID.randomUUID().toString()
                Tokens.insert(
                    TokenDTO(
                        rowId = UUID.randomUUID().toString(),
                        login = receive.login,
                        token = token
                    )
                )
                call.respond(LoginResponseRemote(token = token))
            } else {
                call.respond(HttpStatusCode.BadRequest, "Invalid password")
            }
        }
    }
}