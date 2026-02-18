package com.ctr04.touchpad.domain.entities.remoteInput

// https://source.android.com/docs/core/interaction/input/keyboard-devices#hid-consumer-page-0x0c
object RemoteInput {

    // Navigation
    val REMOTE_INPUT_MENU by lazy { byteArrayOf(0x40, 0x00) }
    val REMOTE_INPUT_MENU_PICK by lazy { byteArrayOf(0x41, 0x00) }
    val REMOTE_INPUT_MENU_UP by lazy { byteArrayOf(0x42, 0x00) }
    val REMOTE_INPUT_MENU_DOWN by lazy { byteArrayOf(0x43, 0x00) }
    val REMOTE_INPUT_MENU_LEFT by lazy { byteArrayOf(0x44, 0x00) }
    val REMOTE_INPUT_MENU_RIGHT by lazy { byteArrayOf(0x45, 0x00) }

    // Multimedia
    val REMOTE_INPUT_PLAY_PAUSE by lazy { byteArrayOf(0xCD.toByte(), 0x00) }
    val REMOTE_INPUT_PLAY by lazy { byteArrayOf(0xB0.toByte(), 0x00) }
    val REMOTE_INPUT_PAUSE by lazy { byteArrayOf(0xB1.toByte(), 0x00) }
    val REMOTE_INPUT_STOP by lazy { byteArrayOf(0xB7.toByte(), 0x00) }
    val REMOTE_INPUT_REPEAT by lazy { byteArrayOf(0xBC.toByte(), 0x00) }
    val REMOTE_INPUT_PREVIOUS_TRACK by lazy { byteArrayOf(0xB6.toByte(), 0x00) }
    val REMOTE_INPUT_NEXT_TRACK by lazy { byteArrayOf(0xB5.toByte(), 0x00) }
    val REMOTE_INPUT_REWIND by lazy { byteArrayOf(0xB4.toByte(), 0x00) }
    val REMOTE_INPUT_FORWARD by lazy { byteArrayOf(0xB3.toByte(), 0x00) }
    val REMOTE_INPUT_CLOSED_CAPTIONS by lazy { byteArrayOf(0x61, 0x00) }

    // Volume
    val REMOTE_INPUT_VOLUME_UP by lazy { byteArrayOf(0xE9.toByte(), 0x00) }
    val REMOTE_INPUT_VOLUME_DOWN by lazy { byteArrayOf(0xEA.toByte(), 0x00) }
    val REMOTE_INPUT_VOLUME_MUTE by lazy { byteArrayOf(0xE2.toByte(), 0x00) }

    // Brightness
    val REMOTE_INPUT_BRIGHTNESS_UP by lazy { byteArrayOf(0x6F.toByte(), 0x00) }
    val REMOTE_INPUT_BRIGHTNESS_DOWN by lazy { byteArrayOf(0x70.toByte(), 0x00) }

    // Channel
    val REMOTE_INPUT_CHANNEL_UP by lazy { byteArrayOf(0x9C.toByte(), 0x00) }
    val REMOTE_INPUT_CHANNEL_DOWN by lazy { byteArrayOf(0x9D.toByte(), 0x00) }

    // Others
    val REMOTE_INPUT_HOME by lazy { byteArrayOf(0x23, 0x02) }
    val REMOTE_INPUT_BACK by lazy { byteArrayOf(0x24, 0x02) }
    val REMOTE_INPUT_POWER by lazy { byteArrayOf(0x30, 0x00) }
    val REMOTE_INPUT_RED_MENU_BUTTON by lazy { byteArrayOf(0x69, 0x00) }
    val REMOTE_INPUT_GREEN_MENU_BUTTON by lazy { byteArrayOf(0x6A, 0x00) }
    val REMOTE_INPUT_BLUE_MENU_BUTTON by lazy { byteArrayOf(0x6B, 0x00) }
    val REMOTE_INPUT_YELLOW_MENU_BUTTON by lazy { byteArrayOf(0x6C, 0x00) }

}