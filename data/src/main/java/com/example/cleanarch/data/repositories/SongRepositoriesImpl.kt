package com.example.cleanarch.data.repositories

import com.example.cleanarch.data.base.BaseRepository
import com.example.cleanarch.data.database.dao.SongDao
import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.models.SongEntity
import com.example.cleanarch.domain.repositories.SongRepository
import com.example.cleanarch.domain.utils.Resource
import com.example.cleanarch.domain.utils.mapper.mapToSongEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongRepositoriesImpl @Inject constructor(private val songDao: SongDao) : SongRepository,
    BaseRepository() {

    override fun getSong(): Flow<Resource<List<SongEntity>>> = makeRequest {
        songDao.getSong().mapToSongEntity()
    }

    override fun createSong(song: Song): Flow<Resource<Unit>> = makeRequest {
        songDao.createSong(song)
    }

    override fun updateSong(song: Song): Flow<Resource<Unit>> = makeRequest {
        songDao.updateSong(song)
    }

    override fun deleteSong(song: Song): Flow<Resource<Unit>> = makeRequest {
        songDao.deleteSong(song)
    }
}