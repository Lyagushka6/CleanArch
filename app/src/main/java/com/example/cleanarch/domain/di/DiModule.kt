package com.example.cleanarch.domain.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cleanarch.data.database.SongDatabase
import com.example.cleanarch.data.database.dao.SongDao
import com.example.cleanarch.data.repositories.SongRepositoriesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DiModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(
        @ApplicationContext context: Context,
    ) = Room.databaseBuilder(context, RoomDatabase::class.java, "songs").build()

    @Provides
    fun provideSongDao(songDatabase: SongDatabase) = songDatabase.getSongDao()

    @Provides
    fun provideSongRepository(songDao: SongDao) = SongRepositoriesImpl(songDao)
}