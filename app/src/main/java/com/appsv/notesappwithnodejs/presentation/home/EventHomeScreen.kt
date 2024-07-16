package com.appsv.notesappwithnodejs.presentation.home

sealed class EventHomeScreen {

    data class SelectedPriority(val priority : String) : EventHomeScreen()
    data class PinOrUnpinAndSave(val id : String , val index : Int) : EventHomeScreen()
}