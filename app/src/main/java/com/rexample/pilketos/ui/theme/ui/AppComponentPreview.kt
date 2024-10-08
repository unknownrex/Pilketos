package com.rexample.pilketos.ui.theme.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.testing.TestNavHostController
import com.rexample.pilketos.ui.theme.PILKETOSTheme

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VotingScreenPreview() {
    PILKETOSTheme(darkTheme = false) {
        VotingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun QuickCountPreview() {
    PILKETOSTheme(darkTheme = false) {
        QuickCountScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val context = LocalContext.current
    val navController = remember { TestNavHostController(context) }
    PILKETOSTheme {
        LoginScreen(
            navController = navController
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview() {
    PILKETOSTheme {
        MainScreen()
    }
}