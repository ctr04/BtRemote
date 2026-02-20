package com.ctr04.touchpad.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctr04.touchpad.common.utils.TouchpadEventBus
import com.ctr04.touchpad.common.utils.KEYBOARD_REPORT_ID
import com.ctr04.touchpad.common.utils.MOUSE_REPORT_ID
import com.ctr04.touchpad.domain.entities.remoteInput.MouseAction
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.VirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.settings.RemoteSettings
import com.ctr04.touchpad.domain.usecases.RemoteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class RemoteViewModel(
    useCase: RemoteUseCase,
): ViewModel() {

    // ---- Settings ----

    val remoteSettingsFlow: Flow<RemoteSettings> = useCase.remoteSettingsFlow
    private var virtualX = 500f // Track the cursor position
    private var virtualY = 500f

    // ---- Send ----

    private fun sendReport(id: Int, bytes: ByteArray): Boolean {
        if (id != MOUSE_REPORT_ID) return false

        val actionByte = bytes[0]
        val dx = bytes[1].toInt().toFloat()
        val dy = bytes[2].toInt().toFloat()
        val scroll = if (bytes.size > 3) bytes[3].toInt().toFloat() else 0f

        virtualX += dx
        virtualY += dy

        TouchpadEventBus.emit(
            TouchpadEventBus.MouseData(
                dx = dx,
                dy = dy,
                isClick = actionByte,
                scroll = scroll
            )
        )

        return true
    }

    // Mouse
    val sendMouseReport: (MouseAction, Float, Float, Float) -> Unit = { input, x, y, wheel ->
        val xInt = x.roundToInt().coerceIn(-127, 127)
        val yInt = y.roundToInt().coerceIn(-127, 127)
        val bytes: ByteArray = byteArrayOf(input.byte, xInt.toByte(), yInt.toByte(), wheel.roundToInt().toByte())
        sendReport(MOUSE_REPORT_ID, bytes)
    }

    // Keyboard
    val sendKeyboardReport: (ByteArray) -> Unit = { bytes -> sendReport(KEYBOARD_REPORT_ID, bytes) }

    // Text (Keyboard)
    private var sendTextJob: Job? = null
    val sendTextReport: (String, VirtualKeyboardLayout, Boolean) -> Unit = { text, virtualKeyboardLayout, shouldSendEnter ->
        if(sendTextJob?.isActive != true) {
            sendTextJob = viewModelScope.launch(Dispatchers.Default) {
            }
        }
    }
}