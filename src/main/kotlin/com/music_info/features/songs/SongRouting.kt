package com.music_info.features.songs

import com.music_info.constants.QueryParams.ANNUAL_YEAR
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.util.url

fun Application.configureSongRouting() {

    routing {
        get("/songs") {
            val songController = SongController()
            songController.fetchAllSongs(call)
        }

        get("/songs/annual_period") {
            url {
                parameters.append(ANNUAL_YEAR, "")
            }
            val songController = SongController()
            songController.fetchSongsByAnnualPeriod(call)
        }
    }
}