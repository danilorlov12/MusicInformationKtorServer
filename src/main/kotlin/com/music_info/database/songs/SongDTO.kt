package com.music_info.database.songs

class SongDTO(
    val songId: String,
    val artist: String,
    val name: String,
    val album: String,
    val year: String?,
    val genre: String?,
    val language: String?,
    val country: String?
)
