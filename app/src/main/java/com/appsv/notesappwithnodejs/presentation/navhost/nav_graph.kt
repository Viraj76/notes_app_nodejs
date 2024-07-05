package com.appsv.notesappwithnodejs.presentation.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsv.notesappwithnodejs.presentation.home.HomeScreen
import com.appsv.notesappwithnodejs.presentation.add_notes.AddNoteScreen

@Composable
fun SetupNavHost(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HomeScreen){

        composable<HomeScreen>
         {
           HomeScreen(navController = navController)
        }

        composable<AddNoteScreen>{
            AddNoteScreen()
        }
    }

}