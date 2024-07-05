package com.appsv.notesappwithnodejs.presentation.main_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.appsv.notesappwithnodejs.R
import com.appsv.notesappwithnodejs.presentation.navhost.SetupNavHost
import com.appsv.notesappwithnodejs.presentation.ui.theme.NotesAppWithNodeJSTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                Color(0xFF03045E).toArgb(),     // res color as int
            )
        )

        installSplashScreen()
        setContent {
            NotesAppWithNodeJSTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = colorResource(id = R.color.dark_blue))
                ){
                    SetupNavHost()
                }
            }
        }
    }
}
