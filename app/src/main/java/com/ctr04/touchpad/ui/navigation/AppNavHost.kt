package com.ctr04.touchpad.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

private val enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    slideInHorizontally(
        initialOffsetX = { fullWidth -> fullWidth }
    )
}

private val exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    slideOutHorizontally (
        targetOffsetX = { fullWidth -> -fullWidth }
    )
}

private val popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
    slideInHorizontally(
        initialOffsetX = { fullWidth -> -fullWidth }
    )
}

private val popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
    slideOutHorizontally (
        targetOffsetX = { fullWidth -> fullWidth }
    )
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String,
    settingsScreen: @Composable () -> Unit,
    thirdLibrariesScreen: @Composable () -> Unit,
    remoteScreen: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(
            route = AppNavDestination.SettingsDestination.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition
        ) {
            settingsScreen()
        }

        composable(
            route = AppNavDestination.ThirdLibrariesDestination.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition
        ) {
            thirdLibrariesScreen()
        }

        composable(
            route = AppNavDestination.RemoteDestination.route,
            enterTransition = enterTransition,
            exitTransition = exitTransition,
            popEnterTransition = popEnterTransition,
            popExitTransition = popExitTransition
        ) {
            remoteScreen()
        }
    }
}

fun NavHostController.navigateTo(
    route: String,
    launchSingleTop: Boolean = true
) {
    this.navigate(route) {
        this.launchSingleTop = launchSingleTop
    }
}