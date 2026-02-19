package com.ctr04.touchpad.common.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.Backspace
import androidx.compose.material.icons.automirrored.rounded.BluetoothSearching
import androidx.compose.material.icons.automirrored.rounded.HelpOutline
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.rounded.KeyboardReturn
import androidx.compose.material.icons.automirrored.rounded.KeyboardTab
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.automirrored.rounded.Send
import androidx.compose.material.icons.automirrored.rounded.VolumeDown
import androidx.compose.material.icons.automirrored.rounded.VolumeOff
import androidx.compose.material.icons.automirrored.rounded.VolumeUp
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ArrowDownward
import androidx.compose.material.icons.rounded.ArrowUpward
import androidx.compose.material.icons.rounded.Bluetooth
import androidx.compose.material.icons.rounded.BluetoothDisabled
import androidx.compose.material.icons.rounded.BrightnessHigh
import androidx.compose.material.icons.rounded.BrightnessLow
import androidx.compose.material.icons.rounded.Circle
import androidx.compose.material.icons.rounded.ClosedCaption
import androidx.compose.material.icons.rounded.Computer
import androidx.compose.material.icons.rounded.ControlCamera
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.DeviceUnknown
import androidx.compose.material.icons.rounded.Dialpad
import androidx.compose.material.icons.rounded.FastForward
import androidx.compose.material.icons.rounded.FastRewind
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.HealthAndSafety
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Key
import androidx.compose.material.icons.rounded.Keyboard
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material.icons.rounded.Link
import androidx.compose.material.icons.rounded.LinkOff
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Mouse
import androidx.compose.material.icons.rounded.MusicVideo
import androidx.compose.material.icons.rounded.OpenInBrowser
import androidx.compose.material.icons.rounded.OpenWith
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.PowerSettingsNew
import androidx.compose.material.icons.rounded.Print
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material.icons.rounded.Repeat
import androidx.compose.material.icons.rounded.Router
import androidx.compose.material.icons.rounded.ScreenshotMonitor
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.SettingsRemote
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material.icons.rounded.SkipPrevious
import androidx.compose.material.icons.rounded.Smartphone
import androidx.compose.material.icons.rounded.SpaceBar
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.material.icons.rounded.Toys
import androidx.compose.material.icons.rounded.Usb
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.Watch
import org.koin.core.component.KoinComponent

object AppIcons: KoinComponent {

    // ---- UI ----

    val Back get() = Icons.AutoMirrored.Rounded.ArrowBack
    val Help get() = Icons.AutoMirrored.Rounded.HelpOutline
    val Settings get() = Icons.Rounded.Settings
    val Info get() = Icons.Outlined.Info

    val Appearance get() = Icons.Rounded.Palette
    val OpenInBrowser get() = Icons.Rounded.OpenInBrowser
    val Lock get() = Icons.Rounded.Lock
    val Key get() = Icons.Rounded.Key

    // ---- Remote ----

    val RemoteControl get() = Icons.Rounded.SettingsRemote
    val Mute get() = Icons.AutoMirrored.Rounded.VolumeOff
    val VolumeUp get() = Icons.AutoMirrored.Rounded.VolumeUp
    val VolumeDown get() = Icons.AutoMirrored.Rounded.VolumeDown

    // ---- Keyboard ----

    val Keyboard get() = Icons.Rounded.Keyboard
    val KeyboardTab get() = Icons.AutoMirrored.Rounded.KeyboardTab
    val KeyboardScreenshot get() = Icons.Rounded.ScreenshotMonitor
    val KeyboardBackspace get() = Icons.AutoMirrored.Rounded.Backspace
    val KeyboardEnter get() = Icons.AutoMirrored.Rounded.KeyboardReturn
    val SpaceBar get() = Icons.Rounded.SpaceBar
    val KeyboardArrowUp get() = Icons.Rounded.KeyboardArrowUp
    val KeyboardArrowLeft get() = Icons.AutoMirrored.Rounded.KeyboardArrowLeft
    val KeyboardArrowDown get() = Icons.Rounded.KeyboardArrowDown
    val KeyboardArrowRight get() = Icons.AutoMirrored.Rounded.KeyboardArrowRight

    val Send get() = Icons.AutoMirrored.Rounded.Send

    // ---- Mouse ----

    val Mouse get() = Icons.Rounded.Mouse
    val MouseScrollUp get() = Icons.Rounded.ArrowUpward
    val MouseScrollDown get() = Icons.Rounded.ArrowDownward
}