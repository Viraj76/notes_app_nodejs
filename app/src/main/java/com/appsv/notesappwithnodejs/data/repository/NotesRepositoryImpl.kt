package com.appsv.notesappwithnodejs.data.repository

import android.util.Log
import com.appsv.notesappwithnodejs.common.util.Resource
import com.appsv.notesappwithnodejs.data.remote.NotesAPI
import com.appsv.notesappwithnodejs.domain.models.Notes
import com.appsv.notesappwithnodejs.domain.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NotesRepositoryImpl(
    private val notesAPI: NotesAPI
) : NotesRepository {


    override suspend fun saveNotes(notes: Notes): Flow<Resource<String>> = flow{

        emit(Resource.Loading())

        val status : Int = notesAPI.saveNotes(notes).code()


        try {
            if (status == 201){
                emit(Resource.Success("Notes Saved!"))
            }
            else{
                //  error
                emit(Resource.Error("Unable to save notes"))
            }
        }
        catch (e : Exception){
            emit(Resource.Error(e.message!!))
        }


    }
}