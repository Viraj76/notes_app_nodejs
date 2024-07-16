package com.appsv.notesappwithnodejs.presentation.home.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
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
import org.bson.types.ObjectId
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
private fun Prevv() {

    NotesCard(notes = Notes(
        noteTitle = "Comprehensive Marketing Strategy Meeting with the Entire Sales and Marketing Team",
        noteDescription = "every team . Schedule follow-up meetings to track progress and make adjustments as necessary.",
        notePriority = "High",
        pinned = false,
        date = "2024-07-07"
    )){

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NotesCard(
    modifier: Modifier = Modifier,
    notes : Notes,
    onPin : (String) -> Unit
) {

    val chipColor = remember(notes.notePriority) {
        when (notes.notePriority) {
            "Medium" -> Color.Yellow
            "High" -> Color.Red
            else -> Color.Green
        }
    }

    val favouriteIcon = remember(notes.pinned) {
        if(notes.pinned) R.drawable.baseline_star_24
        else R.drawable.baseline_star_border_24
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
                    horizontalArrangement = Arrangement.SpaceBetween
                ){

                    IconButton(
                        modifier = Modifier.align(Alignment.CenterVertically),
                        onClick = {
                            onPin(notes._id!!)
                        }) {
                        Icon(
                            modifier = Modifier
                                .size(30.dp)
                            ,
                            imageVector = ImageVector.vectorResource(id = favouriteIcon),
                            contentDescription = "Star icon",
                            tint = if (notes.pinned) chipColor else colorResource(id = R.color.grey),
                        )
                    }

                    CustomFilterChip(
                        label = notes.notePriority,
                        color = chipColor,
                        alphaValue = 0.4f,
                        selected =  false){}
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
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = formatTimestampToDDMMYYYY(notes.date!!),
                    color = colorResource(id = R.color.light_blue),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                )
            }
        }

    }

}

@RequiresApi(Build.VERSION_CODES.O)
fun formatTimestampToDDMMYYYY(timestamp: String): String {
    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val zonedDateTime = ZonedDateTime.parse(timestamp, formatter)

    // Convert to IST (Indian Standard Time) which is UTC+5:30
    val zoneId = ZoneId.of("Asia/Kolkata")
    val istDateTime = zonedDateTime.withZoneSameInstant(zoneId)

    // Format day, month, and year
    val day = istDateTime.dayOfMonth.toString().padStart(2, '0')
    val month = istDateTime.monthValue.toString().padStart(2, '0')
    val year = istDateTime.year.toString()

    return "$day-$month-$year"
}
