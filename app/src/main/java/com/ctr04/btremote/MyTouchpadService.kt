package com.ctr04.btremote

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import android.widget.ImageView
import com.ctr04.btremote.domain.entities.remoteInput.MouseAction
import kotlinx.coroutines.*

class MyTouchpadService : AccessibilityService() {

    private lateinit var windowManager: WindowManager
    private lateinit var cursorView: ImageView
    private var virtualX = 500f
    private var virtualY = 500f

    private val serviceScope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
    }

    override fun onServiceConnected() {
        super.onServiceConnected()

        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        cursorView = ImageView(this).apply {
            setImageResource(R.drawable.android_14_cursor)
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY, // Essential!
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
            x = virtualX.toInt()
            y = virtualY.toInt()
        }

        windowManager.addView(cursorView, params)

        serviceScope.launch {
            TouchpadEventBus.events.collect { data ->
                processRemoteInput(data.dx, data.dy, data.isClick)
            }
        }
    }

    private fun processRemoteInput(dx: Float, dy: Float, isClick: Byte) {
        val metrics = resources.displayMetrics

        virtualX = (virtualX + dx).coerceIn(0f, metrics.widthPixels.toFloat())
        virtualY = (virtualY + dy).coerceIn(0f, metrics.heightPixels.toFloat())

        updateCursorUI(virtualX, virtualY)

        when (isClick) {
            MouseAction.MOUSE_CLICK_LEFT.byte, MouseAction.PAD_TAP.byte -> {
                injectClick(virtualX, virtualY)
            }
            MouseAction.MOUSE_CLICK_RIGHT.byte -> {
                injectRightClick(virtualX, virtualY)
            }
            MouseAction.MOUSE_CLICK_MIDDLE.byte -> {
                performGlobalAction(GLOBAL_ACTION_HOME)
            }
        }
    }

    private fun updateCursorUI(x: Float, y: Float) {
        if (!::cursorView.isInitialized) return
        val params = cursorView.layoutParams as WindowManager.LayoutParams
        params.x = x.toInt()
        params.y = y.toInt()
        windowManager.updateViewLayout(cursorView, params)
    }

    private fun injectClick(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }
        val stroke = GestureDescription.StrokeDescription(path, 0, 100)
        val gesture = GestureDescription.Builder().addStroke(stroke).build()
        dispatchGesture(gesture, null, null)
    }

    private fun injectRightClick(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }

        val longPressStroke = GestureDescription.StrokeDescription(path, 0, 600)

        val gestureBuilder = GestureDescription.Builder()
        gestureBuilder.addStroke(longPressStroke)

        dispatchGesture(gestureBuilder.build(), null, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
        if (::cursorView.isInitialized) windowManager.removeView(cursorView)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
}
