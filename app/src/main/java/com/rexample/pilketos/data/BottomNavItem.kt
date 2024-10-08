package com.rexample.pilketos.data

import androidx.annotation.DrawableRes
import com.rexample.pilketos.R

sealed class BottomNavItem (
    val title: String,
    @DrawableRes val icon: Int,
    val route: String
) {
    object Voting: BottomNavItem(
        title = "Voting",
        icon = R.drawable.ic_voting,
        route = "voting"
    )
    object QuickCount: BottomNavItem(
        title = "Quick Count",
        icon = R.drawable.ic_quickcount,
        route = "quick_count"
    )
    object Account: BottomNavItem(
        title = "Account",
        icon = R.drawable.ic_account,
        route = "account"
    )


}