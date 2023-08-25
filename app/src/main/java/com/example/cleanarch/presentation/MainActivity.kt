package com.example.cleanarch.presentation

import android.os.Bundle
import androidx.activity.viewModels
import com.example.cleanarch.presentation.base.BaseActivity
import com.example.cleanarch.R
import com.example.cleanarch.data.models.Song


class MainActivity : BaseActivity() {

    private val viewModel by viewModels<SongViewModel>()
    val song = Song(1, "I Need A Dollar", "Aloe Blacc", "4:18")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSongs()
        addSong()
        updateSong()
        deleteSong()
    }

    private fun deleteSong() {
        viewModel.deleteSong(song)
        viewModel.deleteAllSong.collectInfo(
            loadingState = { println("progress bar") },
            errorState = { println("error") },
            emptyState = { println("empty: $it") },
            successState = { println("data: $it") }
        )
    }

    private fun updateSong() {
        viewModel.updateSong(song)
        viewModel.updateAllSong.collectInfo(
            loadingState = { println("progress bar") },
            errorState = { println("error") },
            emptyState = { println("empty: $it") },
            successState = { println("data: $it") }
        )
    }

    private fun addSong() {
        viewModel.addSong(song)
        viewModel.addAllSong.collectInfo(
            loadingState = { println("progress bar") },
            errorState = { println("error") },
            emptyState = { println("empty: $it") },
            successState = { println("data: $it") }
        )
    }


    private fun getSongs() {
        viewModel.getAllSong()
        viewModel.getAllSongs.collectInfo(
            loadingState = { println("progress bar") },
            errorState = { println("error") },
            emptyState = { println("empty: $it") },
            successState = { println("data: $it") }
        )
    }
}