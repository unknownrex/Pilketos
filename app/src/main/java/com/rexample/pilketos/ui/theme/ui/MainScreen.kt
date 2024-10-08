package com.rexample.pilketos.ui.theme.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import com.rexample.pilketos.R
import com.rexample.pilketos.data.BottomNavItem
import com.rexample.pilketos.ui.theme.PILKETOSTheme
import com.rexample.pilketos.ui.theme.poppins


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if(currentRoute != "login") {
                BottomNavigationBar(navController = navController)
            }
        },
        topBar = {
            if(currentRoute != "login") {
                PilketosTopBar()
            }
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                NavigationGraph(navController = navController)
            }
        }
    )
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable(BottomNavItem.Voting.route) {
            VotingScreen()
        }
        composable(BottomNavItem.QuickCount.route) {
            QuickCountScreen()
        }
        composable(BottomNavItem.Account.route) {
            AccountScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.surface
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navItems = listOf(
            BottomNavItem.Voting,
            BottomNavItem.QuickCount,
            BottomNavItem.Account
        )

        navItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },

                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        tint = if (currentRoute == item.route) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.secondary
                        }
                    )
                },

                label = {
                    Text(
                        text = item.title,
                        fontFamily = poppins,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = if (currentRoute == item.route) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.secondary
                        }
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PilketosTopBar() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.pilketos_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp),
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.background)
    )
}

@Preview
@Composable
fun TopBarPreview(){
    PILKETOSTheme {
        PilketosTopBar()
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    val context = LocalContext.current
    val navController = remember { TestNavHostController(context) }
    PILKETOSTheme {
        BottomNavigationBar(navController = navController)
    }

}