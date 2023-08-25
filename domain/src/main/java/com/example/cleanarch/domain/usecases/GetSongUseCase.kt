package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.repositories.SongRepository
import javax.inject.Inject

class GetSongUseCase @Inject constructor(
    private val repository: SongRepository
) {

    fun getSong()= repository.getSong()
}