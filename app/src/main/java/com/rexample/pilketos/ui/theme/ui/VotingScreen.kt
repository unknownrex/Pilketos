package com.rexample.pilketos.ui.theme.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rexample.pilketos.data.LocalCalonKetosData
import com.rexample.pilketos.model.CalonKetos
import com.rexample.pilketos.ui.theme.PILKETOSTheme

@Composable
fun VotingScreen() {
    Column {

    }
}

@Composable
fun CalonKetosCard(
    calonKetos: CalonKetos,
    modifier: Modifier = Modifier
) {
    Card(shape = RoundedCornerShape(12.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = calonKetos.image),
                contentDescription = null,
                modifier = modifier
                    .clip(RoundedCornerShape(6.dp))
                    .width(266.dp)
            )
            Spacer(Modifier.height(16.dp))
            NameAndClass(calonKetosNama = calonKetos.nama, calonKetosKelas = calonKetos.kelasJurusan)
            Spacer(Modifier.height(16.dp))
            CardButton({},{})
        }
    }
}

@Composable
fun NameAndClass(
    calonKetosNama: Int,
    calonKetosKelas: Int
) {
    Text(
        text = stringResource(id = calonKetosNama),
        style =  MaterialTheme.typography.titleLarge,
    )
    Text(
        text = stringResource(id = calonKetosKelas),
        style =  MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun CardButton(
    onPliihClick: () -> Unit,
    onVisiMisiClick: () -> Unit
) {
    Column(Modifier.width(266.dp)){
        Button(
            onClick = onPliihClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Pilih",
                style =  MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(Modifier.height(8.dp))
        OutlinedButton(
            onClick = onPliihClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Visi Misi",
                style =  MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
fun ComponentPreview() {
    PILKETOSTheme {
        CalonKetosCard(calonKetos = LocalCalonKetosData.defaultCalon)
    }
}