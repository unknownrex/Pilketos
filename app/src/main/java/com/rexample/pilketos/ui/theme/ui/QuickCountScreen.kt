package com.rexample.pilketos.ui.theme.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rexample.pilketos.data.LocalCalonKetosData
import com.rexample.pilketos.model.CalonKetos

@Composable
fun QuickCountScreen(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        SuaraMasukText(totalSuaraMasuk = 100)
        LazyColumn {
            items(LocalCalonKetosData.allCalonKetos) {
                QuickCountCard(calonKetos = it)
            }
        }
    }
}

@Composable
fun SuaraMasukText(
    totalSuaraMasuk: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(20.dp).fillMaxWidth()
    ) {
        Text(
            text = "SUARA MASUK:",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSecondary
        )
        Text(
            text = "${totalSuaraMasuk}%",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun QuickCountCard(
    calonKetos: CalonKetos
) {
    Box(modifier = Modifier.padding(16.dp)) {
        Card(
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier
                .shadow(
                    elevation = 3.dp,
                    shape = RoundedCornerShape(8.dp),
                    clip = true
                )

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(calonKetos.image), contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .size(56.dp),
                    contentScale = ContentScale.Crop
                )

                Spacer(Modifier.width(12.dp))

                Column {
                    Text(
                        text = stringResource(calonKetos.nama),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = stringResource(calonKetos.kelasJurusan),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }

                Spacer(Modifier.weight(1f))
                Text(
                    text = "${calonKetos.suaraMasuk}%",
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = (0).dp)
                .size(16.dp)
                .shadow(elevation = 3.dp, shape = CircleShape, clip = false)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = calonKetos.id.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

