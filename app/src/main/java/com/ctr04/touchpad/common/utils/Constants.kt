package com.ctr04.touchpad.common.utils

import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.KeyboardLanguage
import com.ctr04.touchpad.domain.entities.settings.ThemeEntity

const val NOTIFICATION_ID = 1
const val NOTIFICATION_CHANNEL_ID = "notificationChannelId"

const val SOURCE_CODE_LINK = "https://github.com/ctr04/Touchpad-for-Android-Desktop-Mode"

const val DATA_STORE_PREFERENCES_SETTINGS_NAME = "dataStoreSettings"

// ---- Settings default value ----

// ---- Appearance ----
val DEFAULT_THEME = ThemeEntity.SYSTEM
const val DEFAULT_USE_BLACK_COLOR_FOR_DARK_THEME: Boolean = false
const val DEFAULT_USE_FULL_SCREEN: Boolean = false

// ---- Mouse ----
const val DEFAULT_MOUSE_SPEED: Float = 1.5f
const val DEFAULT_SHOULD_INVERT_MOUSE_SCROLLING_DIRECTION: Boolean = false
const val DEFAULT_USE_GYROSCOPE: Boolean = false

// ---- Keyboard ----
val DEFAULT_KEYBOARD_LANGUAGE: KeyboardLanguage = KeyboardLanguage.ENGLISH_US
const val DEFAULT_MUST_CLEAR_INPUT_FIELD: Boolean = true
const val DEFAULT_USE_ADVANCED_KEYBOARD: Boolean = false
const val DEFAULT_USE_ADVANCED_KEYBOARD_INTEGRATED: Boolean = false

// ---- Remote ----
const val DEFAULT_USE_ENTER_FOR_SELECTION: Boolean = false

// ---- HID Descriptor ----

const val KEYBOARD_REPORT_ID = 0x01
const val MOUSE_REPORT_ID = 0x03

val REMOTE_INPUT_NONE = byteArrayOf(0x00, 0x00)
