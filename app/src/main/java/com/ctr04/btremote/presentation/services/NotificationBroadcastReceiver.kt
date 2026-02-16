package com.ctr04.btremote.presentation.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ctr04.btremote.domain.entities.remoteInput.RemoteInput
import org.koin.core.component.KoinComponent

class NotificationBroadcastReceiver: BroadcastReceiver(), KoinComponent {

    companion object {
        const val ACTION_VOLUME_INC = "action_volume_up"
        const val ACTION_VOLUME_DEC = "action_volume_down"
        const val ACTION_MULTIMEDIA_PLAY_PAUSE = "action_multimedia_play_pause"
        const val ACTION_MULTIMEDIA_PREVIOUS = "action_multimedia_previous"
        const val ACTION_MULTIMEDIA_NEXT = "action_multimedia_next"
        const val ACTION_LEFT = "action_left"
        const val ACTION_RIGHT = "action_right"
        const val ACTION_UP = "action_up"
        const val ACTION_DOWN = "action_down"
        const val ACTION_PICK = "action_pick"
        const val ACTION_BACK = "action_back"
        const val ACTION_HOME = "action_home"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action) {
            ACTION_VOLUME_INC -> sendReport(RemoteInput.REMOTE_INPUT_VOLUME_UP)
            ACTION_VOLUME_DEC -> sendReport(RemoteInput.REMOTE_INPUT_VOLUME_DOWN)
            ACTION_MULTIMEDIA_PLAY_PAUSE -> sendReport(RemoteInput.REMOTE_INPUT_PLAY_PAUSE)
            ACTION_MULTIMEDIA_PREVIOUS -> sendReport(RemoteInput.REMOTE_INPUT_REWIND)
            ACTION_MULTIMEDIA_NEXT -> sendReport(RemoteInput.REMOTE_INPUT_FORWARD)
            ACTION_LEFT -> sendReport(RemoteInput.REMOTE_INPUT_MENU_LEFT)
            ACTION_RIGHT -> sendReport(RemoteInput.REMOTE_INPUT_MENU_RIGHT)
            ACTION_UP -> sendReport(RemoteInput.REMOTE_INPUT_MENU_UP)
            ACTION_DOWN -> sendReport(RemoteInput.REMOTE_INPUT_MENU_DOWN)
            ACTION_PICK -> sendReport(RemoteInput.REMOTE_INPUT_MENU_PICK)
            ACTION_BACK -> sendReport(RemoteInput.REMOTE_INPUT_BACK)
            ACTION_HOME -> sendReport(RemoteInput.REMOTE_INPUT_HOME)
        }
    }

    private fun sendReport(bytes: ByteArray) {
    }
}