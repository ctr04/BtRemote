package com.ctr04.btremote.domain.entities

import android.bluetooth.BluetoothHidDevice

data class DeviceHidConnectionState(
    val state: Int = BluetoothHidDevice.STATE_DISCONNECTED,
    val deviceName: String = ""
)