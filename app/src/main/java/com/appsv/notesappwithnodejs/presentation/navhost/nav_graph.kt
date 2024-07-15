package com.appsv.notesappwithnodejs.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsv.notesappwithnodejs.presentation.home.HomeScreen
import com.appsv.notesappwithnodejs.presentation.add_notes.AddNoteScreen
import com.appsv.notesappwithnodejs.presentation.add_notes.ViewModelAddNoteScreen
import com.appsv.notesappwithnodejs.presentation.home.ViewModelHome
import org.koin.androidx.compose.koinViewModel

@Composable
fun SetupNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeScreen
    ){

        composable<HomeScreen>
         {
             val viewModel : ViewModelHome = koinViewModel()
             val state by viewModel.getNotesState.collectAsState()
           HomeScreen(
               navController = navController, state = state , viewModel::onEvent
           )
        }

        composable<AddNoteScreen>{
            val viewModel : ViewModelAddNoteScreen = koinViewModel()
            val state by viewModel.notesState.collectAsState()

            AddNoteScreen(
                navController,
                state = state,
                event = viewModel::onEvent
            )
        }
    }

}