package com.music_info.features.songs

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureSongRouting() {

    routing {
        get("/songs") {
            val songController = SongController()
            songController.fetchAllSongs(call)
        }

        get("/songs/annual_period") {
            val songController = SongController()
            songController.fetchSongsByAnnualPeriod(call)
        }
    }
}