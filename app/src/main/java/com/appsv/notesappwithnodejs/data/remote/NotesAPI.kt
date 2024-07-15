package com.appsv.notesappwithnodejs.data.remote

import com.appsv.notesappwithnodejs.domain.models.Notes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface NotesAPI {

    @POST("/save-notes")
    suspend fun saveNotes(@Body notes: Notes) : Response<Notes>

    @GET("/notes")
    suspend fun getNotes() : Response<List<Notes>>

    @GET("/filter-notes")
    suspend fun filterNotes(
        @Query("priority")  priority : String
    ) : Response<List<Notes>>

}