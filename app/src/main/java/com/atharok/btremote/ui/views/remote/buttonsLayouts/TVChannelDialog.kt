package com.atharok.btremote.ui.views.remote.buttonsLayouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.atharok.btremote.R
import com.atharok.btremote.ui.components.TemplateDialog
import com.atharok.btremote.ui.components.TextLarge
import com.atharok.btremote.ui.theme.surfaceElevationHigh

@Composable
fun TVChannelDialog(
    tvChannelUpTouchDown: () -> Unit,
    tvChannelDownTouchDown: () -> Unit,
    tvChannel1TouchDown: () -> Unit,
    tvChannel2TouchDown: () -> Unit,
    tvChannel3TouchDown: () -> Unit,
    tvChannel4TouchDown: () -> Unit,
    tvChannel5TouchDown: () -> Unit,
    tvChannel6TouchDown: () -> Unit,
    tvChannel7TouchDown: () -> Unit,
    tvChannel8TouchDown: () -> Unit,
    tvChannel9TouchDown: () -> Unit,
    tvChannel0TouchDown: () -> Unit,
    remoteTouchUp: () -> Unit,
    keyboardTouchUp: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    TemplateDialog(
        title = {
            TextLarge(text = stringResource(R.string.tv))
        },
        content = {
            TVChannelLayout(
                tvChannelIncTouchDown = tvChannelUpTouchDown,
                tvChannelDecTouchDown = tvChannelDownTouchDown,
                tvChannel1TouchDown = tvChannel1TouchDown,
                tvChannel2TouchDown = tvChannel2TouchDown,
                tvChannel3TouchDown = tvChannel3TouchDown,
                tvChannel4TouchDown = tvChannel4TouchDown,
                tvChannel5TouchDown = tvChannel5TouchDown,
                tvChannel6TouchDown = tvChannel6TouchDown,
                tvChannel7TouchDown = tvChannel7TouchDown,
                tvChannel8TouchDown = tvChannel8TouchDown,
                tvChannel9TouchDown = tvChannel9TouchDown,
                tvChannel0TouchDown = tvChannel0TouchDown,
                remoteTouchUp = remoteTouchUp,
                keyboardTouchUp = keyboardTouchUp,
                modifier = Modifier.aspectRatio(3f / 4f)
            )
        },
        modifier = modifier,
        dismissButtonText = stringResource(R.string.close),
        onDismissRequest = onDismissRequest
    )
}

@Composable
private fun TVChannelLayout(
    tvChannelIncTouchDown: () -> Unit,
    tvChannelDecTouchDown: () -> Unit,
    tvChannel1TouchDown: () -> Unit,
    tvChannel2TouchDown: () -> Unit,
    tvChannel3TouchDown: () -> Unit,
    tvChannel4TouchDown: () -> Unit,
    tvChannel5TouchDown: () -> Unit,
    tvChannel6TouchDown: () -> Unit,
    tvChannel7TouchDown: () -> Unit,
    tvChannel8TouchDown: () -> Unit,
    tvChannel9TouchDown: () -> Unit,
    tvChannel0TouchDown: () -> Unit,
    remoteTouchUp: () -> Unit,
    keyboardTouchUp: () -> Unit,
    modifier: Modifier = Modifier,
    buttonShape: Shape = CircleShape,
    buttonElevation: Dp = surfaceElevationHigh(),
    padding: Dp = dimensionResource(id = R.dimen.padding_large)
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Absolute.spacedBy(padding)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalArrangement = Arrangement.Absolute.spacedBy(padding)
        ) {
            TVChannelButton1(
                touchDown = tvChannel1TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton2(
                touchDown = tvChannel2TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton3(
                touchDown = tvChannel3TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalArrangement = Arrangement.Absolute.spacedBy(padding)
        ) {
            TVChannelButton4(
                touchDown = tvChannel4TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton5(
                touchDown = tvChannel5TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton6(
                touchDown = tvChannel6TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            horizontalArrangement = Arrangement.Absolute.spacedBy(padding)
        ) {
            TVChannelButton7(
                touchDown = tvChannel7TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton8(
                touchDown = tvChannel8TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton9(
                touchDown = tvChannel9TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().weight(1f),
            Arrangement.spacedBy(padding)
        ) {
            TVChannelPreviousButton(
                touchDown = tvChannelDecTouchDown,
                touchUp = remoteTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelButton0(
                touchDown = tvChannel0TouchDown,
                touchUp = keyboardTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
            TVChannelNextButton(
                touchDown = tvChannelIncTouchDown,
                touchUp = remoteTouchUp,
                modifier = Modifier.weight(1f),
                shape = buttonShape,
                elevation = buttonElevation
            )
        }
    }
}