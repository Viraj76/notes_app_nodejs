package com.appsv.notesappwithnodejs.presentation.add_notes.component

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun CustomFilterChip(
    label: String,
    color: Color,
    selected: Boolean,
    onClick: () -> Unit
) {

    FilterChip(
        onClick = onClick,
        label = {
            Text(
                label,
                color = color.copy(alpha = 0.7f)
            )
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    tint = color,
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors().copy(
            containerColor = color.copy(alpha = 0.2f) ,
            labelColor =color ,
            leadingIconColor = color,
            selectedContainerColor = color.copy(alpha = 0.2f)
        ),
        border = null  // Remove the border
    )
}