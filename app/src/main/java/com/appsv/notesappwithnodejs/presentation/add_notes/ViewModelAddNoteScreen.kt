package com.appsv.notesappwithnodejs.presentation.add_notes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ViewModelAddNoteScreen : ViewModel(){

    private val _stateNote = MutableStateFlow(StateAddNoteScreen())
    val notesState = _stateNote

    fun onEvent(event : EventAddNoteScreen){
        when(event){
            is EventAddNoteScreen.NoteTitle -> {
                _stateNote.value = notesState.value.copy(notesTitle = event.title)
            }

            is EventAddNoteScreen.NoteDescription ->{
                _stateNote.value = notesState.value.copy(notesDescription = event.description)
            }
            is EventAddNoteScreen.NotePriority -> {
                _stateNote.value = notesState.value.copy(notesPriority = event.priority)
            }

        }
    }
}