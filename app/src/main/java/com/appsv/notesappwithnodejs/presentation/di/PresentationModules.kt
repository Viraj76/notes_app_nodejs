package com.appsv.notesappwithnodejs.presentation.di

import com.appsv.notesappwithnodejs.presentation.add_notes.ViewModelAddNoteScreen
import com.appsv.notesappwithnodejs.presentation.home.ViewModelHome
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel{
        ViewModelAddNoteScreen()
    }
    viewModel { ViewModelHome() }
}