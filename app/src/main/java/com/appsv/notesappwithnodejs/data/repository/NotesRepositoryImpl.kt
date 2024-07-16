package com.appsv.notesappwithnodejs.data.repository


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

    override suspend fun getNotes(): Flow<Resource<List<Notes>>>  = flow{
        val status = notesAPI.getNotes().code()
        try {
            val notesList = notesAPI.getNotes().body()
            if (status == 200){
                emit(Resource.Success((notesList)))
            }
            else{
                //  error
                emit(Resource.Error("Unable to get notes"))
            }
        }
        catch (e : Exception){
            emit(Resource.Error(e.message!!))
        }
    }

    override suspend fun filterNotes(priority : String): Flow<Resource<List<Notes>>> = flow {
        emit(Resource.Loading())

        try {
            val status = notesAPI.filterNotes(priority).code()
            if (status == 200){
                val notes  = notesAPI.filterNotes(priority).body()
                emit(Resource.Success(data = notes))
            }
            else{
                emit(Resource.Error(message = "Unable to fetch notes!"))
            }
        }
        catch (e : Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }

    override suspend fun pinNotes(id: String) {
        notesAPI.pinNotes(id)
    }


}