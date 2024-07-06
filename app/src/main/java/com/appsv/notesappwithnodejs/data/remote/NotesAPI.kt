package com.appsv.notesappwithnodejs.data.remote

import com.appsv.notesappwithnodejs.domain.models.Notes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NotesAPI {

    @POST("/save-notes")
    suspend fun saveNotes(@Body notes: Notes) : Response<Notes>
}