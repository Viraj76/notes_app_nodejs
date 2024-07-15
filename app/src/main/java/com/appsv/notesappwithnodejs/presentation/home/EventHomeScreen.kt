package com.appsv.notesappwithnodejs.presentation.home

sealed class EventHomeScreen {

    data class SelectedPriority(val priority : String) : EventHomeScreen()
}