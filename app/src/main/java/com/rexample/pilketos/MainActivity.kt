package com.rexample.pilketos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rexample.pilketos.ui.theme.PILKETOSTheme
import com.rexample.pilketos.ui.theme.ui.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            PILKETOSTheme {
                MainScreen()
            }
        }
    }
}