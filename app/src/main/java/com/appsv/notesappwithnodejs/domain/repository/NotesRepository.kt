package com.appsv.notesappwithnodejs.domain.repository

import androidx.navigation.FloatingWindow
import com.appsv.notesappwithnodejs.common.util.Resource
import com.appsv.notesappwithnodejs.domain.models.Notes
import kotlinx.coroutines.flow.Flow


interface NotesRepository {
      suspend fun saveNotes(notes: Notes) : Flow<Resource<String>>

      suspend fun getNotes() : Flow<Resource<List<Notes>>>

      suspend fun filterNotes(priority : String) : Flow<Resource<List<Notes>>>

      suspend fun pinNotes(id : String)

}

