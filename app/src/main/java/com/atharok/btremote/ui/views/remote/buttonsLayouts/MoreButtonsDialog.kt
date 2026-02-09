package com.atharok.btremote.ui.views.remote.buttonsLayouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.atharok.btremote.R
import com.atharok.btremote.common.utils.REMOTE_INPUT_NONE
import com.atharok.btremote.domain.entities.remoteInput.RemoteInput
import com.atharok.btremote.domain.entities.remoteInput.keyboard.virtualKeyboard.VirtualKeyboardLayout
import com.atharok.btremote.ui.components.TemplateDialog
import com.atharok.btremote.ui.components.TextLarge
import com.atharok.btremote.ui.theme.surfaceElevationHigh

@Composable
fun MoreButtonsDialog(
    sendRemoteKeyReport: (ByteArray) -> Unit,
    sendKeyboardKeyReport: (ByteArray) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    TemplateDialog(
        title = {
            TextLarge(text = stringResource(R.string.more_buttons))
        },
        content = {
            MoreButtonsLayout(
                sendRemoteKeyReport = sendRemoteKeyReport,
                sendKeyboardKeyReport = sendKeyboardKeyReport,
                modifier = Modifier
            )
        },
        modifier = modifier,
        dismissButtonText = stringResource(R.string.close),
        onDismissRequest = onDismissRequest
    )
}

@Composable
private fun MoreButtonsLayout(
    sendRemoteKeyReport: (ByteArray) -> Unit,
    sendKeyboardKeyReport: (ByteArray) -> Unit,
    modifier: Modifier = Modifier,
    buttonShape: Shape = CircleShape,
    buttonElevation: Dp = surfaceElevationHigh(),
    padding: Dp = dimensionResource(id = R.dimen.padding_large)
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(padding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
            PlayButton(
                sendRemoteKeyReport = sendRemoteKeyReport,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            PauseButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_PAUSE) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            StopButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_STOP) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            RepeatButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_REPEAT) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
            RewindButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_REWIND) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            ForwardButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_FORWARD) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            PreviousTrackButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_PREVIOUS_TRACK) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            NextTrackButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_NEXT_TRACK) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
            ClosedCaptionsButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_CLOSED_CAPTIONS) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            ScreenshotButton(
                touchDown = { sendKeyboardKeyReport(VirtualKeyboardLayout.KEYBOARD_KEY_PRINT_SCREEN) },
                touchUp = { sendKeyboardKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            BrightnessDownButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_BRIGHTNESS_DOWN) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            BrightnessUpButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_BRIGHTNESS_UP) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(padding)
        ) {
            RedMenuButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_RED_MENU_BUTTON) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            GreenMenuButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_GREEN_MENU_BUTTON) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            BlueMenuButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_BLUE_MENU_BUTTON) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            YellowMenuButton(
                touchDown = { sendRemoteKeyReport(RemoteInput.REMOTE_INPUT_YELLOW_MENU_BUTTON) },
                touchUp = { sendRemoteKeyReport(REMOTE_INPUT_NONE) },
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
    }
}