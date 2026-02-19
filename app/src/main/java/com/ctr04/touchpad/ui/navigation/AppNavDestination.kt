package com.ctr04.touchpad.ui.navigation

sealed class AppNavDestination(val route: String) {
    data object AccessibilityPermissionsDestination: AppNavDestination(route = "accessibility_permissions_route")
    data object SettingsDestination: AppNavDestination(route = "settings_route")
    data object ThirdLibrariesDestination: AppNavDestination(route = "third_libraries_route")
    data object RemoteDestination: AppNavDestination(route = "remote_route")
}