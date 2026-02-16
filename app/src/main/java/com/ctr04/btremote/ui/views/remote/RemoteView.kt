package com.ctr04.btremote.ui.views.remote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.Dp
import com.ctr04.btremote.R
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.BackButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.BrightnessVerticalButtons
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.ClosedCaptionsButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.HomeButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.MenuButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.MultimediaLayout
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.PowerButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton0
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton1
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton2
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton3
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton4
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton5
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton6
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton7
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton8
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelButton9
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.TVChannelVerticalButtons
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.VolumeMuteButton
import com.ctr04.btremote.ui.views.remote.buttonsLayouts.VolumeVerticalButtons

@Composable
fun RemoteView(
    multimediaPlayPauseTouchDown: () -> Unit,
    multimediaPreviousTouchDown: () -> Unit,
    multimediaNextTouchDown: () -> Unit,
    volumeUpTouchDown: () -> Unit,
    volumeDownTouchDown: () -> Unit,
    volumeMuteTouchDown: () -> Unit,
    closedCaptionsTouchDown: () -> Unit,
    backTouchDown: () -> Unit,
    homeTouchDown: () -> Unit,
    menuTouchDown: () -> Unit,
    powerTouchDown: () -> Unit,
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
    modifier: Modifier = Modifier
) {
    val shape = CircleShape
    val padding: Dp = dimensionResource(id = R.dimen.padding_normal)

    Column(modifier = modifier) {
        MultimediaLayout(
            multimediaPlayPauseTouchDown = multimediaPlayPauseTouchDown,
            multimediaPreviousTouchDown = multimediaPreviousTouchDown,
            multimediaNextTouchDown = multimediaNextTouchDown,
            remoteTouchUp = remoteTouchUp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(padding),
            shape = shape
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                VolumeVerticalButtons(
                    volumeUpButtonTouchDown = volumeUpTouchDown,
                    volumeDownButtonTouchDown = volumeDownTouchDown,
                    buttonTouchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(2f)
                        .padding(padding)
                        .align(Alignment.Start),
                    shape = shape
                )

                VolumeMuteButton(
                    touchDown = volumeMuteTouchDown,
                    touchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                BackButton(
                    touchDown = backTouchDown,
                    touchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                TVChannelButton1(
                    touchDown = tvChannel1TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton4(
                    touchDown = tvChannel4TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton7(
                    touchDown = tvChannel7TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                HomeButton(
                    touchDown = homeTouchDown,
                    touchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                TVChannelButton2(
                    touchDown = tvChannel2TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton5(
                    touchDown = tvChannel5TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton8(
                    touchDown = tvChannel8TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton0(
                    touchDown = tvChannel0TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                TVChannelButton3(
                    touchDown = tvChannel3TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton6(
                    touchDown = tvChannel6TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                TVChannelButton9(
                    touchDown = tvChannel9TouchDown,
                    touchUp = keyboardTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                MenuButton(
                    touchDown = menuTouchDown,
                    touchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )
            }

            Column(
                modifier = Modifier.weight(1f)
            ) {
                TVChannelVerticalButtons(
                    tvChannelUpButtonTouchDown = tvChannelUpTouchDown,
                    tvChannelDownButtonTouchDown = tvChannelDownTouchDown,
                    buttonTouchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(2f)
                        .padding(padding)
                        .align(Alignment.End),
                    shape = shape
                )

                ClosedCaptionsButton(
                    touchDown = closedCaptionsTouchDown,
                    touchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )

                PowerButton(
                    touchDown = powerTouchDown,
                    touchUp = remoteTouchUp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )
            }
        }
    }
}

@Composable
fun MinimalistRemoteView(
    multimediaPlayPauseTouchDown: () -> Unit,
    multimediaPreviousTouchDown: () -> Unit,
    multimediaNextTouchDown: () -> Unit,
    volumeUpTouchDown: () -> Unit,
    volumeDownTouchDown: () -> Unit,
    volumeMuteTouchDown: () -> Unit,
    closedCaptionsTouchDown: () -> Unit,
    backTouchDown: () -> Unit,
    homeTouchDown: () -> Unit,
    menuTouchDown: () -> Unit,
    powerTouchDown: () -> Unit,
    brightnessUpTouchDown: () -> Unit,
    brightnessDownTouchDown: () -> Unit,
    remoteTouchUp: () -> Unit,
    showTVChannelButtons: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = CircleShape
    val padding: Dp = dimensionResource(id = R.dimen.padding_normal)

    Column(modifier = modifier) {
        MultimediaLayout(
            multimediaPlayPauseTouchDown = multimediaPlayPauseTouchDown,
            multimediaPreviousTouchDown = multimediaPreviousTouchDown,
            multimediaNextTouchDown = multimediaNextTouchDown,
            remoteTouchUp = remoteTouchUp,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(padding),
            shape = shape
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f).padding(padding)) {
                VolumeVerticalButtons(
                    volumeUpButtonTouchDown = volumeUpTouchDown,
                    volumeDownButtonTouchDown = volumeDownTouchDown,
                    buttonTouchUp = remoteTouchUp,
                    modifier = Modifier.align(Alignment.Start),
                    shape = shape
                )
            }

            Column(
                modifier = Modifier.weight(2f)
            ) {
                Row(
                    modifier = Modifier.weight(1f)
                ) {
                    VolumeMuteButton(
                        touchDown = volumeMuteTouchDown,
                        touchUp = remoteTouchUp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(padding),
                        shape = shape
                    )

                    ClosedCaptionsButton(
                        touchDown = closedCaptionsTouchDown,
                        touchUp = remoteTouchUp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(padding),
                        shape = shape
                    )
                }
                TVChannelButton(
                    touchDown = {},
                    touchUp = showTVChannelButtons,
                    modifier = Modifier
                        .weight(1f)
                        .padding(padding),
                    shape = shape
                )
            }

            Column(modifier = Modifier.weight(1f).padding(padding)) {
                BrightnessVerticalButtons(
                    brightnessUpButtonTouchDown = brightnessUpTouchDown,
                    brightnessDownButtonTouchDown = brightnessDownTouchDown,
                    buttonTouchUp = remoteTouchUp,
                    modifier = Modifier.align(Alignment.End),
                    shape = shape
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween
        ) {
            BackButton(
                touchDown = backTouchDown,
                touchUp = remoteTouchUp,
                modifier = Modifier
                    .weight(1f)
                    .padding(padding),
                shape = shape
            )
            HomeButton(
                touchDown = homeTouchDown,
                touchUp = remoteTouchUp,
                modifier = Modifier
                    .weight(1f)
                    .padding(padding),
                shape = shape
            )
            MenuButton(
                touchDown = menuTouchDown,
                touchUp = remoteTouchUp,
                modifier = Modifier
                    .weight(1f)
                    .padding(padding),
                shape = shape
            )
            PowerButton(
                touchDown = powerTouchDown,
                touchUp = remoteTouchUp,
                modifier = Modifier
                    .weight(1f)
                    .padding(padding),
                shape = shape
            )
        }
    }
}