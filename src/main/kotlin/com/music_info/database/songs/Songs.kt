package com.music_info.database.songs

import com.music_info.database.counts.Counts
import org.jetbrains.exposed.sql.JoinType
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Songs : Table("songs") {
    private val id = Songs.varchar("id", 10)
    private val name = Songs.varchar("name", 75)
    private val artist = Songs.varchar("artist", 75)
    private val album = Songs.varchar("album", 75)
    private val year = Songs.varchar("year", 5)
    private val genre = Songs.varchar("genre", 25)
    private val language = Songs.varchar("language", 25)
    private val country = Songs.varchar("country", 25)

    fun fetchSongs(): List<SongDTO> {
        return try {
            transaction {
                Songs.selectAll().toList()
                    .map {
                        SongDTO(
                            id = it[this@Songs.id],
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

    fun fetchSongsByYearPeriod(annualYear: String): List<SongByAnnualPeriodDTO> {
        return try {
            transaction {
                Counts.join(Songs, JoinType.INNER, additionalConstraint = {
                    Songs.id eq Counts.songId
                }).slice(artist, name, album, year, Counts.playCount).select {
                    Counts.annualPeriod.eq(annualYear)
                }.orderBy(Counts.playCount, SortOrder.DESC)
                    .map {
                        SongByAnnualPeriodDTO(
                            artist = it[artist],
                            name = it[name],
                            album = it[album],
                            year = it[year],
                            playCount = it[Counts.playCount]
                        )
                    }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}