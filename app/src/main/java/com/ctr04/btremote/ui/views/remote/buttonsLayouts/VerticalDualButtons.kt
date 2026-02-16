package com.ctr04.btremote.ui.views.remote.buttonsLayouts

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.ctr04.btremote.R
import com.ctr04.btremote.common.extensions.autoMirroredIcon
import com.ctr04.btremote.common.utils.AppIcons
import com.ctr04.btremote.ui.components.ButtonContentTemplate
import com.ctr04.btremote.ui.components.RemoteButtonSurface
import com.ctr04.btremote.ui.theme.surfaceElevationMedium

@Composable
private fun VerticalLayout(
    contentUp: @Composable () -> Unit,
    contentDown: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    RemoteButtonSurface(
        modifier = modifier,
        shape = shape,
        elevation = elevation
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.aspectRatio(1f).weight(1f, false)) {
                contentUp()
            }
            Box(modifier = Modifier.aspectRatio(1f).weight(1f, false)) {
                contentDown()
            }
        }
    }
}

@Composable
private fun VerticalLayout(
    topButtonTouchDown: () -> Unit,
    topIcon: ImageVector,
    @StringRes topIconDescription: Int,
    bottomButtonTouchDown: () -> Unit,
    bottomIcon: ImageVector,
    @StringRes bottomIconDescription: Int,
    buttonTouchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape
) {
    VerticalLayout(
        contentUp = {
            ButtonContentTemplate(
                touchDown = topButtonTouchDown,
                touchUp = buttonTouchUp,
                shape = shape
            ) {
                Icon(
                    imageVector = topIcon,
                    contentDescription = stringResource(id = topIconDescription),
                    modifier = Modifier.autoMirroredIcon(topIcon).fillMaxSize(0.5f)
                )
            }
        },
        contentDown = {
            ButtonContentTemplate(
                touchDown = bottomButtonTouchDown,
                touchUp = buttonTouchUp,
                shape = shape
            ) {
                Icon(
                    imageVector = bottomIcon,
                    contentDescription = stringResource(id = bottomIconDescription),
                    modifier = Modifier.autoMirroredIcon(bottomIcon).fillMaxSize(0.5f)
                )
            }
        },
        modifier = modifier,
        shape = shape
    )
}

// ---- Specific ----

@Composable
fun VolumeVerticalButtons(
    volumeUpButtonTouchDown: () -> Unit,
    volumeDownButtonTouchDown: () -> Unit,
    buttonTouchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape
) {
    VerticalLayout(
        topButtonTouchDown = volumeUpButtonTouchDown,
        topIcon = AppIcons.VolumeUp,
        topIconDescription = R.string.volume_up,
        bottomButtonTouchDown = volumeDownButtonTouchDown,
        bottomIcon = AppIcons.VolumeDown,
        bottomIconDescription = R.string.volume_down,
        buttonTouchUp = buttonTouchUp,
        modifier = modifier,
        shape = shape
    )
}

@Composable
fun TVChannelVerticalButtons(
    tvChannelUpButtonTouchDown: () -> Unit,
    tvChannelDownButtonTouchDown: () -> Unit,
    buttonTouchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape
) {
    VerticalLayout(
        topButtonTouchDown = tvChannelUpButtonTouchDown,
        topIcon = AppIcons.TVChannelUp,
        topIconDescription = R.string.next_channel,
        bottomButtonTouchDown = tvChannelDownButtonTouchDown,
        bottomIcon = AppIcons.TVChannelDown,
        bottomIconDescription = R.string.previous_channel,
        buttonTouchUp = buttonTouchUp,
        modifier = modifier,
        shape = shape
    )
}

@Composable
fun BrightnessVerticalButtons(
    brightnessUpButtonTouchDown: () -> Unit,
    brightnessDownButtonTouchDown: () -> Unit,
    buttonTouchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape
) {
    VerticalLayout(
        topButtonTouchDown = brightnessUpButtonTouchDown,
        topIcon = AppIcons.BrightnessUp,
        topIconDescription = R.string.brightness_up,
        bottomButtonTouchDown = brightnessDownButtonTouchDown,
        bottomIcon = AppIcons.BrightnessDown,
        bottomIconDescription = R.string.brightness_down,
        buttonTouchUp = buttonTouchUp,
        modifier = modifier,
        shape = shape
    )
}