package com.appsv.notesappwithnodejs.data.di

import com.appsv.notesappwithnodejs.data.remote.NotesAPI
import com.appsv.notesappwithnodejs.data.repository.NotesRepositoryImpl
import com.appsv.notesappwithnodejs.domain.repository.NotesRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


fun provideNotesApi() : NotesAPI{
    return Retrofit.Builder()
        .baseUrl("http://192.168.100.102:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NotesAPI::class.java)
}

fun provideNotesRepository(notesAPI: NotesAPI) : NotesRepository{
    return NotesRepositoryImpl(notesAPI)
}


val dataModules = module {

    single { provideNotesApi() }

    single { provideNotesRepository(get()) }

}