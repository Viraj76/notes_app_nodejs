package com.appsv.notesappwithnodejs.presentation.add_notes

sealed class EventAddNoteScreen {

    data class NoteTitle(val title : String) : EventAddNoteScreen()
    data class NoteDescription(val description : String) : EventAddNoteScreen()
    data class NotePriority(val priority : String) : EventAddNoteScreen()

}