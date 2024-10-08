package com.rexample.pilketos.ui.theme.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rexample.pilketos.R
import com.rexample.pilketos.ui.theme.poppins
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.rexample.pilketos.data.BottomNavItem

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: PilketosViewModel = viewModel(),
    navController: NavHostController
) {
    var nisnInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    val state by viewModel.uiState.collectAsState()

    if (state.isUserLoggedIn) {
        LaunchedEffect(Unit) {
            navController.navigate(BottomNavItem.Voting.route) {
                popUpTo(navController.graph.startDestinationId) { inclusive = true }
                launchSingleTop = true
            }
        }
    }

    Column(
        modifier
            .padding(30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        PilketosLogo(Modifier.padding(top = 90.dp, bottom = 90.dp))
        Column(
            Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(Modifier.height(24.dp))
            LoginField(
                state = state,
                onLoginClick = { nisnInput, passwordInput ->
                    viewModel.Login(nisnInput, passwordInput)
                }
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Lupa password?",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSecondary
            )

        }
    }
}


@Composable
fun LoginField(
    state: PilketosUiState,
    onLoginClick: (String, String) -> Unit
) {
    var nisnInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    Column {
        OutlinedTextField(
            value = nisnInput,
            shape = RoundedCornerShape(8.dp),
            onValueChange = {nisnInput = it},
            label = {
                Text(text = "NISN", color = MaterialTheme.colorScheme.secondaryContainer)
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.labelMedium,
            isError = state.loginError
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = passwordInput,
            shape = RoundedCornerShape(8.dp),
            onValueChange = { passwordInput = it },
            label = {
                Text(text = "Password", color = MaterialTheme.colorScheme.secondaryContainer)
            },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.labelMedium,
            isError = state.loginError
        )
        if (state.loginError) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "NISN atau Password salah. Silahkan coba lagi",
                color = MaterialTheme.colorScheme.error,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { onLoginClick(nisnInput, passwordInput)},
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Login",
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = poppins,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
fun PilketosLogo(modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(id = R.drawable.pilketos_logo),
            contentDescription = null,
            modifier = Modifier.width(250.dp)
        )
    }
}
