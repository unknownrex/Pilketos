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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rexample.pilketos.R
import com.rexample.pilketos.ui.theme.PILKETOSTheme
import com.rexample.pilketos.ui.theme.poppins

@Composable
fun LoginScreen() {
    Scaffold { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
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
                LoginField(onLoginClick = {})
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
}


@Composable
fun LoginField(
    onLoginClick: () -> Unit
) {
    var nisn by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column {
        OutlinedTextField(
            value = nisn,
            shape = RoundedCornerShape(8.dp),
            onValueChange = {nisn = it},
            label = {Text("NISN")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            shape = RoundedCornerShape(8.dp),
            onValueChange = { password = it },
            label = { Text("Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            textStyle = MaterialTheme.typography.labelMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tombol Login
        Button(
            onClick = onLoginClick,
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

@Preview
@Composable
fun AppPreview() {
    PILKETOSTheme {
        LoginScreen()
    }
}

@Preview
@Composable
fun LogoPreview() {
    PILKETOSTheme {
        PilketosLogo()
    }
}