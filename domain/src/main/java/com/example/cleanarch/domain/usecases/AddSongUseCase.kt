package com.example.cleanarch.domain.usecases

import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.repositories.SongRepository
import javax.inject.Inject

class AddSongUseCase @Inject constructor(
    private val songRepository: SongRepository
) {

    fun createSong(song: Song) = songRepository.createSong(song)
}