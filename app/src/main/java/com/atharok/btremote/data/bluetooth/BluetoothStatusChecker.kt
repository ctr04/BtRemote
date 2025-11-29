package com.atharok.btremote.data.bluetooth

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.atharok.btremote.presentation.services.BluetoothHidService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BluetoothStatusChecker(
    private val context: Context,
    private val adapter: BluetoothAdapter?
) {

    val isBluetoothSupported: Boolean get() = adapter != null

    private val _isBluetoothEnabled: MutableStateFlow<Boolean> = MutableStateFlow(adapter?.isEnabled == true)
    val isBluetoothEnabled: StateFlow<Boolean> = _isBluetoothEnabled

    // ---- BroadcastReceiver ----

    private val bluetoothStateChangeReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            when(intent?.action) {
                BluetoothAdapter.ACTION_STATE_CHANGED -> {
                    val bluetoothState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
                    when(bluetoothState) {
                        BluetoothAdapter.STATE_ON -> {
                            _isBluetoothEnabled.value = true
                        }
                        BluetoothAdapter.STATE_OFF -> {
                            _isBluetoothEnabled.value = false
                            BluetoothHidService.stop(this@BluetoothStatusChecker.context)
                        }
                    }
                }
            }
        }
    }

    fun registerBluetoothStateReceiver() {
        val filter = IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED)
        context.registerReceiver(bluetoothStateChangeReceiver, filter)
    }

    fun unregisterBluetoothStateReceiver() {
        try {
            context.unregisterReceiver(bluetoothStateChangeReceiver)
        } catch (e: java.lang.RuntimeException) {
            Log.e("unregisterReceiver()", "Receiver already unregister: ${e.message ?: e.toString()}")
        }
    }
}