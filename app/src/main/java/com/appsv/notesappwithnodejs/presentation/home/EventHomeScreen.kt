package com.appsv.notesappwithnodejs.presentation.home

sealed class EventHomeScreen {

    data class SelectedPriority(val priority : String) : EventHomeScreen()
    data class OnPin(val id : String , val index : Int) : EventHomeScreen()
}