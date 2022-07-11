package com.music_info.features.songs

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureSongRouting() {

    routing {
        get("/songs/all"){
            val songController = SongController()
            songController.fetchAllSongs(call)
        }
    }
}