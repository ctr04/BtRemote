package com.ctr04.touchpad.common.utils

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

object TouchpadEventBus {
    data class MouseData(val dx: Float, val dy: Float, val isClick: Byte, val scroll: Float = 0f)

    private val _displayName = MutableStateFlow("Unknown Display")
    val displayName: StateFlow<String> = _displayName.asStateFlow()

    fun updateDisplayName(name: String) {
        _displayName.value = name
    }
    private val _events = MutableSharedFlow<MouseData>(extraBufferCapacity = 64)
    val events = _events.asSharedFlow()

    fun emit(data: MouseData) {
        _events.tryEmit(data)
    }
}