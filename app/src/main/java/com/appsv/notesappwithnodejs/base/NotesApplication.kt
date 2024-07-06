package com.appsv.notesappwithnodejs.base

import android.app.Application
import com.appsv.notesappwithnodejs.data.di.dataModules
import com.appsv.notesappwithnodejs.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NotesApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(
                presentationModule , dataModules
            )

            androidContext(this@NotesApplication)
        }
    }
}