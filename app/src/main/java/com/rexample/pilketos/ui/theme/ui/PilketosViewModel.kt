package com.rexample.pilketos.ui.theme.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.rexample.pilketos.data.LocalCalonKetosData
import com.rexample.pilketos.model.CalonKetos
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PilketosViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PilketosUiState())
    val uiState: StateFlow<PilketosUiState> = _uiState

    fun voteCalon(calondId: Int) {
        _uiState.update {
            it.copy(
                votedCalon = calondId,
                isUserVoted = true,
                isShowingVoteDialog = false
            )
        }
    }

    fun showVoteDialog() {
        _uiState.update {
            it.copy(
                isShowingVoteDialog = true
            )
        }
    }

    fun hideVoteDialog() {
        _uiState.update {
            it.copy(
                isShowingVoteDialog = false
            )
        }
    }
}