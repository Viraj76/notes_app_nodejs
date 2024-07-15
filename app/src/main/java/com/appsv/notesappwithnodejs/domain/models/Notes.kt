package com.appsv.notesappwithnodejs.domain.models

import org.bson.types.ObjectId


data class Notes (
    val _id :String = "",
    val noteTitle : String,
    val noteDescription: String,
    val notePriority: String,
    var pinned : Boolean = false,
    val date : String ?   = null
)

val notesList = listOf(
    Notes(
        noteTitle = "Comprehensive Marketing Strategy Meeting with the Entire Sales and Marketing Team",
        noteDescription = "every team . Schedule follow-up meetings to track progress and make adjustments as necessary.",
        notePriority = "High",
        date = "2024-07-07"
    ),
    Notes(
        noteTitle = "Detailed Grocery Shopping List for the Upcoming Week's Meals and Snacks",
        noteDescription = "Create a detailed list for grfor breakfast, lunch, dinner graind diet and save time during busy weekday diet and save time during busy weekdays.",
        notePriority = "Medium",
        date = "2024-07-08"
    ),
    Notes(
        noteTitle = "Intensive Workout Plan Including Cardio, Strength Training, and Flexibility Exercises",
        noteDescription = "Develop an intensive  muscle groups each ds routine. Track prble goals af necessary.",
        notePriority = "High",
        date = "2024-07-09"
    ),
    Notes(
        noteTitle = "Thorough Reading of 'Atomic Habits' with a Focus on Key Takeaways and Practical Applications",
        noteDescription = "Read 'Atomic Hae detailed notes. Reflect on how to incorporateiends or ort each other in habit formation.",
        notePriority = "Low",
        date = "2024-07-10"
    ),
    Notes(
        noteTitle = "Scheduled Weekly Call with Parents to Discuss Life Updates and Future Plans",
        noteDescription = "Set up a scheduled weekly call with par time to have meaningful conversag. Strengthen famirting each other.",
        notePriority = "High",
        date = "2024-07-11"
    ),
    Notes(
        noteTitle = "Detailed Preparation for Office Presentation Including Data Analysis and Visual Aids",
        noteDescription = "Prepare for the upcoming office presentation by gathverypresentation that resonates with the audience.",
        notePriority = "High",
        date = "2024-07-12"
    ),
    Notes(
        noteTitle = "In-Depth Research for Blog Post on the Latest Technology Trends and Innovations",
        noteDescription = "Conduct in-depth research for a bls. Draft thoroughly before publishing.",
        notePriority = "Medium",
        date = "2024-07-13"
    ),
)
