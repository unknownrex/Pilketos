package com.rexample.pilketos.ui.theme.ui

import androidx.lifecycle.ViewModel
import com.rexample.pilketos.data.LocalAccountData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class PilketosViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PilketosUiState())
    val uiState: StateFlow<PilketosUiState> = _uiState

    fun Login(nisnInput: String, passwordInput: String) {
        val account = LocalAccountData.defaultAccount
        if(nisnInput == account.nisnSiswa && passwordInput == account.passwordAccount) {
            _uiState.update {
                it.copy(isUserLoggedIn = true, loginError = false)
            }
        } else {
            _uiState.update {
                it.copy(loginError = true)
            }
        }
    }
    fun VoteCalon(calondId: Int) {
        _uiState.update {
            it.copy(
                votedCalon = calondId,
                isUserVoted = true,
                isShowingVoteDialog = false
            )
        }
    }

    fun ShowVoteDialog() {
        _uiState.update {
            it.copy(
                isShowingVoteDialog = true
            )
        }
    }

    fun HideVoteDialog() {
        _uiState.update {
            it.copy(
                isShowingVoteDialog = false
            )
        }
    }
}