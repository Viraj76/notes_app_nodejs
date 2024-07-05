package com.appsv.notesappwithnodejs.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.appsv.notesappwithnodejs.R
import com.appsv.notesappwithnodejs.common.components.AppToolBar
import com.appsv.notesappwithnodejs.presentation.navhost.AddNoteScreen


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            AppToolBar(
                title = "Notes",
            )
        }

        FloatingActionButton(
            onClick = {
                    navController.navigate(AddNoteScreen)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd).padding(30.dp),
            containerColor = colorResource(id = R.color.medium_blue)
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white),
            )
        }
    }
}
