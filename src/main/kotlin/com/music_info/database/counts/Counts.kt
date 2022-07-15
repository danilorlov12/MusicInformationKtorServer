package com.music_info.database.counts

import org.jetbrains.exposed.sql.Table

object Counts : Table("counts") {
    val songId = Counts.varchar("song_id", 10)
    val playCount = Counts.integer("play_count")
    val annualPeriod = Counts.varchar("annual_period", 5)
}