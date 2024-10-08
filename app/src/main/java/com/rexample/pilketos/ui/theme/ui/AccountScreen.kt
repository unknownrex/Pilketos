package com.rexample.pilketos.ui.theme.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rexample.pilketos.data.LocalAccountData
import com.rexample.pilketos.model.AccountModel
import com.rexample.pilketos.ui.theme.PILKETOSTheme
import com.rexample.pilketos.ui.theme.poppins

@Composable
fun AccountScreen(modifier: Modifier = Modifier) {
    val accountData = LocalAccountData.defaultAccount
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PhotoProfile(account = accountData)
        NameAndClass(account = accountData)
        Spacer(Modifier.height(40.dp))
        AccountData(account = accountData)
        Spacer(Modifier.weight(1f))
        LogoutButton({})
    }
}

@Composable
fun LogoutButton(
    onLogoutClick: () -> Unit
) {
    Button(
        onClick = onLogoutClick,
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
@Composable
fun PhotoProfile(
    account: AccountModel
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.padding(16.dp)

    ) {
        Box(
            modifier = Modifier
                .size(104.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = CircleShape,
                )
        ) {
            Image(
                painter = painterResource(id = account.photoProfile),
                contentDescription = "Photo Profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .border(4.dp, MaterialTheme.colorScheme.onPrimary, CircleShape)
                    .fillMaxSize()
            )
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(CircleShape)
                .size(28.dp)
                .align(Alignment.BottomEnd)
                .shadow(4.dp, CircleShape),
            colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.onPrimary)
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "Edit Photo Profile",
                modifier = Modifier
                    .size(18.dp),
                tint = Color(0xFF292929)

            )
        }

    }
}

@Composable
fun NameAndClass(account: AccountModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = account.namaSiswa.uppercase(),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        Text(
            text = account.kelasJurusan,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}

@Composable
fun AccountData(account: AccountModel){
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        AccountDataTextRow(textTitle = "NISN", textContent = account.nisnSiswa)
        AccountDataTextRow(textTitle = "TGL LAHIR", textContent = account.tanggalLahir)
        AccountDataTextRow(textTitle = "EMAIL", textContent = account.emailSiswa)
    }
}

@Composable
fun AccountDataTextRow(
    textTitle: String,
    textContent: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        Text(
            text = textTitle,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.secondary
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = textContent,
            color = MaterialTheme.colorScheme.secondaryContainer,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AccountComponentPreview() {
    PILKETOSTheme {
        AccountScreen()
    }
}
