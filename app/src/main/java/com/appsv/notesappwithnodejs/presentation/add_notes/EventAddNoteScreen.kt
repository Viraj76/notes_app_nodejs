package com.appsv.notesappwithnodejs.presentation.add_notes

import com.appsv.notesappwithnodejs.domain.models.Notes

sealed class EventAddNoteScreen {

    data class NoteTitle(val title : String) : EventAddNoteScreen()
    data class NoteDescription(val description : String) : EventAddNoteScreen()
    data class NotePriority(val priority : String) : EventAddNoteScreen()
    data class SaveNote(val notes: Notes) : EventAddNoteScreen()

}