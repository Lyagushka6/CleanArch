package com.example.cleanarch.domain.usecases

import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.repositories.SongRepository
import javax.inject.Inject

class DeleteSongUseCase @Inject constructor(
    private val songRepository: SongRepository
) {

    fun deleteSong(song: Song) = songRepository.deleteSong(song)
}