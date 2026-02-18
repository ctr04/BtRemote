package com.ctr04.touchpad.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.ctr04.touchpad.R
import com.ctr04.touchpad.common.extensions.autoMirroredIcon
import com.ctr04.touchpad.common.utils.AppIcons

// ---- Actions ----

@Composable
private fun TopAppBarAction(
    onClick: () -> Unit,
    image: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = image,
            contentDescription = contentDescription,
            modifier = Modifier.autoMirroredIcon(image)
        )
    }
}

@Composable
fun NavigateUpAction(
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBarAction(
        onClick = navigateUp,
        image = AppIcons.Back,
        contentDescription = stringResource(id = R.string.back),
        modifier = modifier
    )
}

@Composable
fun SettingsAction(
    navigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBarAction(
        onClick = navigateToSettings,
        image = AppIcons.Settings,
        contentDescription = stringResource(id = R.string.settings),
        modifier = modifier
    )
}

@Composable
fun RemoteAction(
    showRemote: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBarAction(
        onClick = showRemote,
        image = AppIcons.RemoteControl,
        contentDescription = stringResource(id = R.string.remote),
        modifier = modifier
    )
}

@Composable
fun KeyboardAction(
    showKeyboard: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBarAction(
        onClick = showKeyboard,
        image = AppIcons.Keyboard,
        contentDescription = stringResource(id = R.string.keyboard),
        modifier = modifier
    )
}