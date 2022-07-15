package com.music_info.features.songs

import com.music_info.database.songs.Songs
import io.ktor.server.application.*
import io.ktor.server.response.*

class SongController {

    suspend fun fetchAllSongs(call: ApplicationCall) {
        call.respond(Songs.fetchSongs().map {
            SongReceiveRemote(
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
        call.respond(Songs.fetchSongsByYearPeriod().map {
            SongByAnnualPeriodReceiveRemote(
                artist = it.artist,
                name = it.name,
                album = it.album,
                year = it.year ?: "",
                playCount = it.playCount.toString()
            )
        })
    }
}