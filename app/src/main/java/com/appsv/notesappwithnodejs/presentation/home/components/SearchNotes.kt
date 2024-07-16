package com.appsv.notesappwithnodejs.presentation.home.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appsv.notesappwithnodejs.R

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
private fun Prev() {
    SearchNotes(searchText = "", onSearchingNotes = {}) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalComposeUiApi
@Composable
fun SearchNotes(
    searchText: String,
    onSearchingNotes: (String) -> Unit,
    onExecuteSearch: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        value = searchText,
        colors = OutlinedTextFieldDefaults.colors().copy(
            focusedTextColor = colorResource(id = R.color.light_blue),
            unfocusedTextColor = colorResource(id = R.color.light_blue),
            focusedContainerColor = colorResource(id = R.color.dark_blue),
            unfocusedContainerColor = colorResource(id = R.color.dark_blue),
            focusedLeadingIconColor = colorResource(id = R.color.light_blue),
            unfocusedLeadingIconColor = colorResource(id = R.color.light_blue),
            focusedIndicatorColor = colorResource(id = R.color.light_blue),
            unfocusedIndicatorColor = colorResource(id = R.color.light_blue),
            focusedLabelColor = colorResource(id = R.color.light_blue),
            unfocusedLabelColor = colorResource(id = R.color.light_blue),
            cursorColor = colorResource(id = R.color.light_blue)
        ),
        onValueChange = {
            onSearchingNotes(it)
            onExecuteSearch()
        },
        label = { Text(text = "Search") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onExecuteSearch()
                keyboardController?.hide()
            },
        ),
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
        textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),
    )
}