package com.music_info.features.songs

import com.music_info.constants.QueryParams.ANNUAL_YEAR
import com.music_info.database.songs.Songs
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respond

class SongController {

    suspend fun fetchAllSongs(call: ApplicationCall) {
        call.respond(Songs.fetchSongs().map {
            SongResponseRemote(
                id = it.id,
                artist = it.artist,
                name = it.name,
                album = it.album,
                year = it.year ?: "",
                genre = it.genre ?: "",
                language = it.language ?: "",
                country = it.country ?: ""
            )
        })
    }

    suspend fun fetchSongsByAnnualPeriod(call: ApplicationCall) {
        call.respond(Songs.fetchSongsByYearPeriod(call.parameters[ANNUAL_YEAR] ?: "").map {
            SongByAnnualPeriodResponseRemote(
                artist = it.artist,
                name = it.name,
                album = it.album,
                year = it.year ?: "",
                playCount = it.playCount.toString()
            )
        })
    }
}