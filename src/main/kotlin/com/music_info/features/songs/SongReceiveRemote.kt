package com.music_info.features.songs

import kotlinx.serialization.Serializable

@Serializable
data class SongReceiveRemote(
    val id: String,
    val name: String,
    val artist: String,
    val album: String,
    val year: String,
    val genre: String,
    val language: String,
    val country: String
)