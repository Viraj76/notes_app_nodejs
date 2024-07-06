package com.appsv.notesappwithnodejs.domain.repository

import com.appsv.notesappwithnodejs.common.util.Resource
import com.appsv.notesappwithnodejs.domain.models.Notes
import kotlinx.coroutines.flow.Flow


interface NotesRepository {
      suspend fun saveNotes(notes: Notes) : Flow<Resource<String>>
}

