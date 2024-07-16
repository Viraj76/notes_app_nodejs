package com.appsv.notesappwithnodejs.presentation.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.appsv.notesappwithnodejs.R
import com.appsv.notesappwithnodejs.common.components.AppToolBar
import com.appsv.notesappwithnodejs.domain.models.notesList
import com.appsv.notesappwithnodejs.presentation.add_notes.component.CustomFilterChip
import com.appsv.notesappwithnodejs.presentation.home.components.NotesCard
import com.appsv.notesappwithnodejs.presentation.home.components.SearchNotes
import com.appsv.notesappwithnodejs.presentation.navhost.AddNoteScreen
import kotlinx.coroutines.launch


@Preview(showSystemUi = true)
@Composable
private fun Prev() {
    HomeScreen(
        navController = rememberNavController(),
        state = StateHomeScreen(),
        event = {}
    )
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    state: StateHomeScreen,
    event: (EventHomeScreen) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.dark_blue))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            AppToolBar(
                title = "Notes",
            )

            SearchNotes(
                searchText = state.searchText,
                onSearchingNotes = { text ->
                    event(EventHomeScreen.SearchNotes(text))
                },
                onExecuteSearch = {
                    event(EventHomeScreen.StartSearchingNotes)
                }
            )
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),

                ) {
                CustomFilterChip(
                    label = "All",
                    color = colorResource(id = R.color.light_blue),
                    selected = state.selectedPriority == "All"
                ) {
                    event(EventHomeScreen.SelectedPriority("All"))
                }
                CustomFilterChip(
                    label = "Low",
                    color = Color.Green,
                    selected = state.selectedPriority == "Low"
                ) {
                    event(EventHomeScreen.SelectedPriority("Low"))
                }
                CustomFilterChip(
                    label = "Medium",
                    color = Color.Yellow,
                    selected = state.selectedPriority == "Medium"
                ) {
                    event(EventHomeScreen.SelectedPriority("Medium"))
                }
                CustomFilterChip(
                    label = "High",
                    color = Color.Red,
                    selected = state.selectedPriority == "High"
                ) {
                    event(EventHomeScreen.SelectedPriority("High"))
                }

            }

            Spacer(modifier = Modifier.height(10.dp))

            if (isNotesFetched(state = state)) {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(6.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalItemSpacing = 8.dp
                ) {
                    itemsIndexed(state.searchedNotes) { index, note ->
                        NotesCard(notes = note) { id ->
                            event(EventHomeScreen.PinOrUnpinAndSave(id, index))
                        }
                    }
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

@Composable
fun isNotesFetched(state: StateHomeScreen): Boolean {
    return when {
        state.gettingNotes -> false
        state.fetchedNotes!!.isNotEmpty() -> true
        else -> false
    }
}

