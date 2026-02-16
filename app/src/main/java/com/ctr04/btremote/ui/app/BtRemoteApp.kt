package com.ctr04.btremote.ui.app

import android.content.Context
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ctr04.btremote.common.extensions.getActivity
import com.ctr04.btremote.domain.entities.settings.AppearanceSettings
import com.ctr04.btremote.presentation.viewmodel.AppScopeViewModel
import com.ctr04.btremote.ui.navigation.AppNavDestination
import com.ctr04.btremote.ui.navigation.AppNavHost
import com.ctr04.btremote.ui.navigation.navigateTo
import com.ctr04.btremote.ui.screens.RemoteScreen
import com.ctr04.btremote.ui.screens.SettingsScreen
import com.ctr04.btremote.ui.screens.ThirdLibrariesScreen
import com.ctr04.btremote.ui.theme.BtRemoteTheme
import com.ctr04.btremote.ui.theme.surfaceElevationLow
import org.koin.androidx.compose.koinViewModel

@Composable
fun BtRemoteApp(
    navController: NavHostController = rememberNavController(),
    appScopeViewModel: AppScopeViewModel = koinViewModel(),
    navigateToSettings: () -> Unit = {
        navController.navigateTo(AppNavDestination.SettingsDestination.route)
    },
    context: Context = LocalContext.current
) {
    val appearance by appScopeViewModel.appearanceSettingsFlow
        .collectAsStateWithLifecycle(AppearanceSettings())

    BtRemoteTheme(
        appearance = appearance
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            tonalElevation = surfaceElevationLow()
        ) {

            // ---- NavHost ----

            AppNavHost(
                navController = navController,

                startDestination = remember {
                    AppNavDestination.RemoteDestination.route
                },

                settingsScreen = {
                    SettingsScreen(
                        navigateUp = { navController.navigateUp() },
                        navigateToThirdLibrariesScreen = {
                            navController.navigateTo(AppNavDestination.ThirdLibrariesDestination.route)
                        },
                        modifier = Modifier
                    )
                },

                thirdLibrariesScreen = {
                    ThirdLibrariesScreen(
                        navigateUp = { navController.navigateUp() },
                        modifier = Modifier
                    )
                },

                remoteScreen = {
                    RemoteScreen(
                        closeApp = { context.getActivity()?.moveTaskToBack(true) },
                        navigateUp = { navController.navigateUp() },
                        navigateToSettings = navigateToSettings,
                        modifier = Modifier
                    )
                },
                modifier = Modifier.windowInsetsPadding(
                    WindowInsets.displayCutout.exclude(
                        WindowInsets.systemBars
                    )
                )
            )
        }
    }
}