package com.appsv.notesappwithnodejs.presentation.home

import com.appsv.notesappwithnodejs.domain.models.Notes


data class StateHomeScreen(
    val gettingNotes : Boolean = false,
    val fetchedNotes : List<Notes> ?= emptyList(),
    val error : String = "",
    val selectedPriority : String = "All",
    val searchText : String = "",
    val searchedNotes : List<Notes> = emptyList()

)