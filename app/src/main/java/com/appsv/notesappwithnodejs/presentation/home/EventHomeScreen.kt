package com.appsv.notesappwithnodejs.presentation.home

sealed class EventHomeScreen {
    data class SelectedPriority(val priority : String) : EventHomeScreen()
    data class PinOrUnpinAndSave(val id : String , val index : Int) : EventHomeScreen()

    data class SearchNotes(val text : String) : EventHomeScreen()
    data object StartSearchingNotes : EventHomeScreen()
}