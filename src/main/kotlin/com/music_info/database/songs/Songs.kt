package com.music_info.database.songs

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Songs : Table("songs") {
    private val songId = Songs.varchar("songId", 10)
    private val name = Songs.varchar("name", 75)
    private val artist = Songs.varchar("artist", 75)
    private val album = Songs.varchar("album", 75)
    private val year = Songs.varchar("year", 4)
    private val genre = Songs.varchar("genre", 25)
    private val language = Songs.varchar("language", 25)
    private val country = Songs.varchar("country", 25)

    fun fetch(): List<SongDTO> {
        return try {
            transaction {
                Songs.selectAll().toList()
                    .map {
                        SongDTO(
                            songId = it[songId],
                            artist = it[artist],
                            name = it[name],
                            album = it[album],
                            year = it[year],
                            genre = it[genre],
                            language = it[language],
                            country = it[country]
                        )
                    }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}