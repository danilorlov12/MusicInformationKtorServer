package com.music_info.features.songs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SongAnnualYearReceive(
    val annualYear: String
)

@Serializable
data class SongResponseRemote(
    val id: String,
    val name: String,
    val artist: String,
    val album: String,
    val year: String,
    val genre: String,
    val language: String,
    val country: String
)

@Serializable
data class SongByAnnualPeriodResponseRemote(
    @SerialName("name") val name: String,
    @SerialName("artist") val artist: String,
    @SerialName("album") val album: String,
    @SerialName("year") val year: String,
    @SerialName("play_count") val playCount: String
)