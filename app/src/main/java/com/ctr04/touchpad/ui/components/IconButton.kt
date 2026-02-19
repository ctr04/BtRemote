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

// ---- Basic IconButton ----

@Composable
fun BasicIconButton(
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier.autoMirroredIcon(icon)
        )
    }
}

// ---- Some common IconButtons ----

@Composable
fun SettingsIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    BasicIconButton(
        onClick = onClick,
        icon = AppIcons.Settings,
        contentDescription = stringResource(id = R.string.settings),
        modifier = modifier
    )
}