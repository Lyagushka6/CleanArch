package com.example.cleanarch.data.database

import androidx.room.Database
import com.example.cleanarch.data.database.dao.SongDao
import com.example.cleanarch.data.models.Song

@Database(entities = [Song::class], [], 1)
abstract class SongDatabase {

    abstract fun getSongDao(): SongDao
}