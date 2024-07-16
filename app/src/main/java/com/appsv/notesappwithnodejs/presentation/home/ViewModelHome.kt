package com.appsv.notesappwithnodejs.presentation.home

import android.util.Log
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsv.notesappwithnodejs.common.util.Resource
import com.appsv.notesappwithnodejs.domain.models.Notes
import com.appsv.notesappwithnodejs.domain.models.notesList
import com.appsv.notesappwithnodejs.domain.repository.NotesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ViewModelHome : ViewModel() , KoinComponent {
    private val notesRepository : NotesRepository by inject()

    private val _getNotesState = MutableStateFlow(StateHomeScreen())
    val getNotesState = _getNotesState

    init {
        getNotes()
    }

    fun onEvent(event : EventHomeScreen){
        when(event){
            is EventHomeScreen.SelectedPriority -> {
                _getNotesState.value = getNotesState.value.copy(selectedPriority = event.priority)
                filterNotes(event.priority)
            }

            is EventHomeScreen.PinOrUnpinAndSave -> {
                val id = event.id
                val index = event.index

                // pin or unpin
                _getNotesState.value = getNotesState.value.copy(
                    fetchedNotes = getNotesState.value.fetchedNotes!!.mapIndexed{currentIndex, notes ->
                        if(index == currentIndex){
                            notes.copy(pinned = !notes.pinned)
                        }
                        else{
                            notes
                        }
                    }.sortedByDescending { it.pinned }
                )

                // save status of pinning

                viewModelScope.launch { notesRepository.pinNotes(id) }
                searchNotes()

            }

            is EventHomeScreen.SearchNotes -> {
                _getNotesState.value = getNotesState.value.copy(searchText = event.text)
            }

            EventHomeScreen.StartSearchingNotes -> {
                searchNotes()
            }
        }
    }

    private fun searchNotes() {
        val searchText = getNotesState.value.searchText.lowercase()

        val searchedNotesList = getNotesState.value.fetchedNotes!!.filter {
            it.noteTitle.lowercase().contains(searchText) ||
            it.noteDescription.lowercase().contains(searchText) ||
            it.notePriority.lowercase().contains(searchText)
        }

        _getNotesState.value = getNotesState.value.copy(searchedNotes = searchedNotesList)
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
                        _getNotesState.value = getNotesState.value.copy(fetchedNotes = resource.data!!.sortedByDescending { it.pinned } , gettingNotes = false)
                        searchNotes()
                    }
                }
            }
        }

    }


    private fun getNotes() {
        viewModelScope.launch {
            notesRepository.getNotes().collect{resource->
                when(resource){
                    is Resource.Success -> {
                        _getNotesState.value = getNotesState.value.copy(fetchedNotes = resource.data!!.sortedByDescending { it.pinned } , gettingNotes = false)
                        searchNotes()
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

private fun getPriorityOrder(priority: String): Int {
    return when (priority) {
        "High" -> 0
        "Medium" -> 1
        "Low" -> 2
        else -> 3
    }
}