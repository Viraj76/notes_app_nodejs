package com.appsv.notesappwithnodejs.domain.models

import com.appsv.notesappwithnodejs.presentation.add_notes.EventAddNoteScreen

data class Notes (
    val noteTitle : String,
    val noteDescription: String,
    val notePriority: String
)