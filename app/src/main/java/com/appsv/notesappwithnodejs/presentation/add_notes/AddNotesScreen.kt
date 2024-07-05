package com.appsv.notesappwithnodejs.presentation.add_notes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.appsv.notesappwithnodejs.R
import com.appsv.notesappwithnodejs.common.components.AppOutlinedTextField
import com.appsv.notesappwithnodejs.common.components.AppToolBar
import com.appsv.notesappwithnodejs.presentation.add_notes.component.CustomFilterChip


@Composable
fun AddNoteScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column {

            AppToolBar(
                title = "Add Note",
                navigationIcon = Icons.AutoMirrored.Default.ArrowBack,
                onNavigationClick = {
                }
            )
            Column(
                modifier = Modifier.padding(8.dp)
            ) {

                Spacer(modifier = Modifier.height(20.dp))

                AppOutlinedTextField(
                    value = "Note Title",
                    onValueChange = {},
                    maxLines = 2,
                )

                Spacer(modifier = Modifier.height(30.dp))

                AppOutlinedTextField(
                    value = "Notes Desc",
                    onValueChange = {},
                    maxLines = 10,
                    height = 300.dp
                )

                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.End),
                ) {
                    CustomFilterChip(
                        label = "Low",
                        color = Color.Green,
                        selected = false,
                        onClick = {
                        }
                    )
                    CustomFilterChip(
                        label = "Medium",
                        color = Color.Yellow,
                        selected = false,
                        onClick = {
                        }
                    )
                    CustomFilterChip(
                        label = "High",
                        color = Color.Red,
                        selected = false,
                        onClick = {
                        }
                    )

                }
            }
        }
        FloatingActionButton(
            onClick = {
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp),
            containerColor = colorResource(id = R.color.medium_blue)
        ) {
            Icon(
                Icons.Filled.Done,
                contentDescription = "Add",
                tint = colorResource(id = R.color.white)
            )
        }

    }
}