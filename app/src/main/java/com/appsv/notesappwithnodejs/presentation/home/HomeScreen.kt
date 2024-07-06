package com.appsv.notesappwithnodejs.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.appsv.notesappwithnodejs.R
import com.appsv.notesappwithnodejs.common.components.AppToolBar
import com.appsv.notesappwithnodejs.domain.models.notesList
import com.appsv.notesappwithnodejs.presentation.home.components.NotesCard
import com.appsv.notesappwithnodejs.presentation.navhost.AddNoteScreen


@Preview(showSystemUi = true)
@Composable
private fun Prev() {
    HomeScreen(navController = rememberNavController())
}


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

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(6.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalItemSpacing = 8.dp
            ) {
                items(notesList){
                    NotesCard(notes = it)
                }
            }

        }

        FloatingActionButton(
            onClick = {
                    navController.navigate(AddNoteScreen)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
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
