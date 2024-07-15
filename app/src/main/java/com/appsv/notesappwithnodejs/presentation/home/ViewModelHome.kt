package com.appsv.notesappwithnodejs.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.notesappwithnodejs.common.util.Resource
import com.appsv.notesappwithnodejs.domain.models.notesList
import com.appsv.notesappwithnodejs.domain.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelHome : ViewModel() , KoinComponent {
    private val notesRepository : NotesRepository by inject()

    private val _getNotesState = MutableStateFlow(StateHomeScreen())
    val getNotesState = _getNotesState

    fun onEvent(event : EventHomeScreen){
        when(event){
            is EventHomeScreen.SelectedPriority -> {
                _getNotesState.value = getNotesState.value.copy(selectedPriority = event.priority)

                filterNotes(event.priority)
            }
        }
    }

    private fun filterNotes(priority: String) {

        viewModelScope.launch {
            notesRepository.filterNotes(priority).collect{resource->
                when(resource){
                    is Resource.Error -> {
                        _getNotesState.value = getNotesState.value.copy(error = resource.message,gettingNotes = false)
                    }
                    is Resource.Loading -> {
                        _getNotesState.value = getNotesState.value.copy(gettingNotes = true)
                    }
                    is Resource.Success ->{
                        _getNotesState.value = getNotesState.value.copy(fetchedNotes = resource.data , gettingNotes = false)
                    }
                }
            }
        }

    }

    init {
        getNotes()
    }

    private fun getNotes() {
        viewModelScope.launch {
            notesRepository.getNotes().collect{resource->
                when(resource){
                    is Resource.Success -> {
                        _getNotesState.value = getNotesState.value.copy(fetchedNotes = resource.data , gettingNotes = false)
                    }
                    is Resource.Loading ->{
                        _getNotesState.value = getNotesState.value.copy(gettingNotes = true)

                    }
                    is Resource.Error -> {
                        _getNotesState.value = getNotesState.value.copy(error = resource.message , gettingNotes = false)
                    }
                }
            }
        }

    }

}

