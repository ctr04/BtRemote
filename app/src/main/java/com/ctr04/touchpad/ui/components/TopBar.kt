package com.ctr04.touchpad.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ctr04.touchpad.ui.theme.surfaceElevationHigh
import com.ctr04.touchpad.ui.theme.surfaceElevationLow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    modifier: Modifier = Modifier,
    navigateUp: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    TopAppBar(
        title = {
            TextLarge(text = title)
        },
        modifier = modifier,
        navigationIcon = navigateUp,
        actions = actions,
        windowInsets = TopAppBarDefaults.windowInsets,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                elevation = surfaceElevationLow()
            ),
            scrolledContainerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                elevation = surfaceElevationHigh()
            )
        ),
        scrollBehavior = scrollBehavior
    )
}