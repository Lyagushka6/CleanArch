package com.example.cleanarch.domain.utils.mapper

import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.models.SongEntity


fun List<Song>.mapToSongEntity() = this.map {
    SongEntity(
        id = it.id,
        name = it.name,
        singer = it.singer,
        timer = it.timer
    )
}