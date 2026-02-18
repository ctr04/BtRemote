package com.ctr04.touchpad

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object TouchpadEventBus {
    data class MouseData(val dx: Float, val dy: Float, val isClick: Byte)

    // Buffer ensures move events aren't dropped during high-speed swipes
    private val _events = MutableSharedFlow<MouseData>(extraBufferCapacity = 64)
    val events = _events.asSharedFlow()

    fun emit(data: MouseData) {
        _events.tryEmit(data)
    }
}
