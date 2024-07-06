package com.appsv.notesappwithnodejs.presentation.home.components

import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.appsv.notesappwithnodejs.R
import com.appsv.notesappwithnodejs.domain.models.Notes
import com.appsv.notesappwithnodejs.presentation.add_notes.component.CustomFilterChip
import kotlin.random.Random

//@Preview
@Composable
fun NotesCard(
    modifier: Modifier = Modifier,
    notes : Notes
) {

    val randomInt = remember { Random.nextInt(2, 7) } // Initialize once
    val chipColor = remember(notes.notePriority) {
        when (notes.notePriority) {
            "Medium" -> Color.Yellow
            "High" -> Color.Red
            else -> Color.Green
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.dark_blue))
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.new_blue)),
            modifier = modifier
                .fillMaxWidth()

        ){
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    CustomFilterChip(
                        label = notes.notePriority,
                        color = chipColor,
                        alphaValue = 0.4f,
                        selected =  false){
                    }
                }

                Text(
                    text = notes.noteTitle,
                    color = colorResource(id = R.color.light_blue),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = notes.noteDescription,
                    color = colorResource(id = R.color.light_blue1),
                    fontSize = 15.sp,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = notes.date,
                    color = colorResource(id = R.color.light_blue),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )




            }
        }

    }



}