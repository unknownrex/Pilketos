package com.rexample.pilketos.ui.theme.ui

import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rexample.pilketos.data.LocalCalonKetosData
import com.rexample.pilketos.model.CalonKetos
import com.rexample.pilketos.ui.theme.PILKETOSTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class)
@Composable
fun VotingScreen(
    viewModel: PilketosViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    val state by viewModel.uiState.collectAsState()

    Column(modifier = modifier.fillMaxSize()) {
        HorizontalPager(
            count = LocalCalonKetosData.allCalonKetos.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val calon = LocalCalonKetosData.allCalonKetos[page]
            CalonKetosCard(
                calonKetos = calon,
                isCalonVoted = state.votedCalon == calon.id,
                isUserVoted = state.isUserVoted,
                onPilihClick = { viewModel.showVoteDialog() },
                onVisiMisiClick = {}
            )
        }

        if (state.isShowingVoteDialog) {
            VoteConfirmDialog(
                onDismissRequest = { viewModel.hideVoteDialog() },
                onConfirmRequest = {
                    viewModel.voteCalon(LocalCalonKetosData.allCalonKetos[pagerState.currentPage].id)
                }
            )
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
    }
}

@Composable
fun VoteConfirmDialog(
    onDismissRequest: () -> Unit,
    onConfirmRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Vote",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Apakah anda yakin untuk memberi vote?",
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(12.dp))
                Row {
                    OutlinedButton(
                        onClick = onDismissRequest,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Tidak")
                    }

                    Spacer(Modifier.width(16.dp))

                    Button(
                        onClick = onConfirmRequest,
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Ya")
                    }

                }
            }
        }
    }
}

@Composable
fun CalonKetosCard(
    calonKetos: CalonKetos,
    isCalonVoted: Boolean,
    isUserVoted: Boolean,
    onPilihClick: () -> Unit,
    onVisiMisiClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier.shadow(
                elevation = 3.dp,
                shape = RoundedCornerShape(12.dp),
                clip = false
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = calonKetos.image),
                    contentDescription = null,
                    modifier = modifier
                        .clip(RoundedCornerShape(6.dp))
                        .size(266.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.height(16.dp))
                NameAndClass(
                    calonKetosNama = calonKetos.nama,
                    calonKetosKelas = calonKetos.kelasJurusan
                )
                Spacer(Modifier.height(16.dp))
                CardButton(
                    onPilihClick = onPilihClick,
                    isCalonVoted = isCalonVoted,
                    isUserVoted = isUserVoted,
                    onVisiClick = onVisiMisiClick,
                )
            }
        }

        Card(
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-12).dp)
                .size(24.dp)
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
                    fontSize = 15.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
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
        color = MaterialTheme.colorScheme.onPrimaryContainer
    )
    Text(
        text = stringResource(id = calonKetosKelas),
        style =  MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.secondary
    )
}

@Composable
fun CardButton(
    onPilihClick: () -> Unit,
    onVisiClick: () -> Unit,
    isCalonVoted: Boolean,
    isUserVoted: Boolean
) {
    Column(Modifier.width(266.dp)) {
        Button(
            onClick = onPilihClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = MaterialTheme.colorScheme.primary,
                disabledContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                disabledContentColor = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            enabled = !isCalonVoted && !isUserVoted
        ) {
            Text(
                text = if (isCalonVoted) "Telah dipilih" else "Pilih",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(Modifier.height(8.dp))
        OutlinedButton(
            onClick = onVisiClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(34.dp),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = "Visi Misi",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComponentPreview() {
    PILKETOSTheme(darkTheme = false) {
        VotingScreen()
    }
}