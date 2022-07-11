package com.music_info.features.songs

import com.music_info.database.songs.Songs
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.jetbrains.exposed.sql.insert
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex.Empty

class SongController {

    suspend fun fetchAllSongs(call: ApplicationCall) {
//        val receive = call.receive<Empty>()
//        val songDTO = Songs.fetch()

        call.respond(Songs.fetch().map {
            SongReceiveRemote(
                songId = it.songId,
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
}