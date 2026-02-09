package com.atharok.btremote.ui.views.remote.buttonsLayouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.atharok.btremote.R
import com.atharok.btremote.common.utils.AppIcons
import com.atharok.btremote.common.utils.REMOTE_INPUT_NONE
import com.atharok.btremote.domain.entities.remoteInput.RemoteInput
import com.atharok.btremote.ui.components.TextSmall
import com.atharok.btremote.ui.theme.surfaceElevationMedium


// ---- More Buttons ----

@Composable
private fun MoreButtonLayout(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    image: ImageVector,
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium(),
    iconTint: Color = LocalContentColor.current
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconRemoteButton(
            touchDown = touchDown,
            touchUp = touchUp,
            image = image,
            contentDescription = text,
            modifier = Modifier.aspectRatio(1f),
            shape = shape,
            elevation = elevation,
            iconTint = iconTint
        )
        TextSmall(text = text)
    }
}

@Composable
fun PlayButton(
    sendRemoteKeyReport: (ByteArray) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_PLAY) },
        touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
        image = AppIcons.MultimediaPlay,
        text = stringResource(id = R.string.play),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun PauseButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaPause,
        text = stringResource(id = R.string.pause),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun StopButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaStop,
        text = stringResource(id = R.string.stop),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun RepeatButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaRepeat,
        text = stringResource(id = R.string.repeat),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun PreviousTrackButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaPreviousTrack,
        text = stringResource(id = R.string.previous_track),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun NextTrackButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaNextTrack,
        text = stringResource(id = R.string.next_track),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun RewindButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaRewind,
        text = stringResource(id = R.string.rewind),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun ForwardButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.MultimediaForward,
        text = stringResource(id = R.string.forward),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun RedMenuButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.Round,
        text = stringResource(id = R.string.red_menu_button),
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        iconTint = Color.Red.copy(alpha = 0.5f)
    )
}

@Composable
fun GreenMenuButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.Round,
        text = stringResource(id = R.string.green_menu_button),
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        iconTint = Color.Green.copy(alpha = 0.5f)
    )
}

@Composable
fun BlueMenuButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.Round,
        text = stringResource(id = R.string.blue_menu_button),
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        iconTint = Color.Blue.copy(alpha = 0.5f)
    )
}

@Composable
fun YellowMenuButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.Round,
        text = stringResource(id = R.string.yellow_menu_button),
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        iconTint = Color.Yellow.copy(alpha = 0.5f)
    )
}

@Composable
fun BrightnessUpButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.BrightnessUp,
        text = stringResource(id = R.string.brightness_up),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun BrightnessDownButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.BrightnessDown,
        text = stringResource(id = R.string.brightness_down),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun ClosedCaptionsButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.ClosedCaption,
        text = stringResource(id = R.string.closed_captions),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}

@Composable
fun ScreenshotButton(
    touchDown: () -> Unit,
    touchUp: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    elevation: Dp = surfaceElevationMedium()
) {
    MoreButtonLayout(
        touchDown = touchDown,
        touchUp = touchUp,
        image = AppIcons.KeyboardScreenshot,
        text = stringResource(id = R.string.screenshot),
        modifier = modifier,
        shape = shape,
        elevation = elevation
    )
}