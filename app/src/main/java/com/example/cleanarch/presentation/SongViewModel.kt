package com.example.cleanarch.presentation

import com.example.cleanarch.presentation.base.BaseViewModel
import com.example.cleanarch.data.models.Song
import com.example.cleanarch.domain.models.SongEntity
import com.example.cleanarch.domain.usecases.AddSongUseCase
import com.example.cleanarch.domain.usecases.DeleteSongUseCase
import com.example.cleanarch.domain.usecases.GetSongUseCase
import com.example.cleanarch.domain.usecases.UpdateSongUseCase
import com.example.cleanarch.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class SongViewModel @Inject constructor(
    private val getSongUseCase: GetSongUseCase,
    private val updateSongUseCase: UpdateSongUseCase,
    private val addSongUseCase: AddSongUseCase,
    private val deleteSongUseCase: DeleteSongUseCase
) : BaseViewModel() {

    private val getMutableStateFlow = MutableStateFlow<UiState<List<SongEntity>>>(UiState.Empty())
    val getAllSongs: StateFlow<UiState<List<SongEntity>>> = getMutableStateFlow

    private val addMutableSateFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val addAllSong: StateFlow<UiState<Unit>> = addMutableSateFlow

    private val updateMutableSateFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val updateAllSong: StateFlow<UiState<Unit>> = updateMutableSateFlow

    private val deleteMutableSateFlow = MutableStateFlow<UiState<Unit>>(UiState.Empty())
    val deleteAllSong: StateFlow<UiState<Unit>> = deleteMutableSateFlow

    fun getAllSong(){
        getSongUseCase.getSong().collectData(getMutableStateFlow)
    }

    fun addSong(song: Song){
        addSongUseCase.createSong(song).collectData(addMutableSateFlow)
    }

    fun updateSong(song: Song){
        updateSongUseCase.updateSong(song).collectData(updateMutableSateFlow)
    }

    fun deleteSong(song: Song) {
        deleteSongUseCase.deleteSong(song).collectData(deleteMutableSateFlow)
    }
}