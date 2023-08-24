package com.example.cleanarch.domain.usecases

import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.repositories.SongRepository
import javax.inject.Inject

class UpdateSongUseCase@Inject constructor(
    private val songRepository: SongRepository
){

    fun updateSong(song: Song) = songRepository.updateSong(song)
}