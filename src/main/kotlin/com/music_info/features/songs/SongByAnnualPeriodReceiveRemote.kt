package com.music_info.features.songs

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SongByAnnualPeriodReceiveRemote(
    @SerialName("name") val name: String,
    @SerialName("artist") val artist: String,
    @SerialName("album") val album: String,
    @SerialName("year") val year: String,
    @SerialName("play_count") val playCount: String
)