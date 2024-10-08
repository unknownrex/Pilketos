package com.rexample.pilketos.ui.theme.ui

data class PilketosUiState (
    val isUserLoggedIn: Boolean = false,
    val loginError: Boolean = false,
    val isUserVoted: Boolean = false,
    val votedCalon: Int? = null,
    val isShowingVisiMisi: Boolean = false,
    val isShowingVoteDialog: Boolean = false
)