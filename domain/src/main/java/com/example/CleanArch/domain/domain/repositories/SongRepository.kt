package com.example.cleanarch.domain.repositories

import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.models.SongEntity
import kotlinx.coroutines.flow.Flow
import com.example.cleanarch.domain.utils.Resource

interface SongRepository {

    fun getSong(): Flow<Resource<List<SongEntity>>>

    fun createSong(song: Song): Flow<Resource<Unit>>

    fun updateSong(song: Song): Flow<Resource<Unit>>

    fun deleteSong(song: Song): Flow<Resource<Unit>>
}