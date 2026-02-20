package com.ctr04.touchpad.data.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.graphics.PixelFormat
import android.hardware.display.DisplayManager
import android.os.Build
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import android.widget.ImageView
import com.ctr04.touchpad.R
import com.ctr04.touchpad.common.utils.TouchpadEventBus
import com.ctr04.touchpad.domain.entities.remoteInput.MouseAction
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlin.math.abs

class MyTouchpadService : AccessibilityService() {

    private lateinit var externalWindowManager: WindowManager
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

        val displayManager = getSystemService(DISPLAY_SERVICE) as DisplayManager
        val displays = displayManager.displays

        val targetDisplay = if (displays.size > 1) displays[1] else displays[0]

        val displayContext = createDisplayContext(targetDisplay)
        externalWindowManager = displayContext.getSystemService(WINDOW_SERVICE) as WindowManager

        cursorView = ImageView(displayContext).apply {
            setImageResource(R.drawable.pointer_arrow)
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_ACCESSIBILITY_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE or
                    WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN or
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
        }

        externalWindowManager.addView(cursorView, params)

        serviceScope.launch {
            TouchpadEventBus.events.collect { data ->
                processRemoteInput(data.dx, data.dy, data.isClick, data.scroll)
            }
        }
    }

    private fun processRemoteInput(dx: Float, dy: Float, isClick: Byte, scroll: Float) {
        val display = externalWindowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getRealMetrics(metrics)

        if (dx != 0f || dy != 0f) {
            virtualX = (virtualX + dx).coerceIn(0f, metrics.widthPixels.toFloat())
            virtualY = (virtualY + dy).coerceIn(0f, metrics.heightPixels.toFloat())
            updateCursorUI(virtualX, virtualY)
        }

        if (scroll != 0f) {
            injectScroll(virtualX, virtualY, scroll)
        } else {
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
    }

    private fun updateCursorUI(x: Float, y: Float) {
        if (!::cursorView.isInitialized) return
        val params = cursorView.layoutParams as WindowManager.LayoutParams
        params.x = x.toInt()
        params.y = y.toInt()
        externalWindowManager.updateViewLayout(cursorView, params)
    }

    private fun injectClick(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }
        val stroke = GestureDescription.StrokeDescription(path, 0, 100)
        val gestureBuilder = GestureDescription.Builder().addStroke(stroke)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val displayId = externalWindowManager.defaultDisplay.displayId
            gestureBuilder.setDisplayId(displayId)
        }

        dispatchGesture(gestureBuilder.build(), null, null)
    }

    private fun injectRightClick(x: Float, y: Float) {
        val path = Path().apply { moveTo(x, y) }

        val longPressStroke = GestureDescription.StrokeDescription(path, 0, 600)

        val gestureBuilder = GestureDescription.Builder()
        gestureBuilder.addStroke(longPressStroke)

        dispatchGesture(gestureBuilder.build(), null, null)
    }

    private fun injectScroll(x: Float, y: Float, scrollAmount: Float) {
        val display = externalWindowManager.defaultDisplay
        val metrics = DisplayMetrics()
        display.getRealMetrics(metrics)

        val startY = y.coerceIn(0f, metrics.heightPixels.toFloat())
        val targetY = (y - (scrollAmount * 100)).coerceIn(0f, metrics.heightPixels.toFloat())

        if (abs(targetY - startY) < 1f) return

        val path = Path().apply {
            moveTo(x, startY)
            lineTo(x, targetY)
        }

        val stroke = GestureDescription.StrokeDescription(path, 0, 200)
        val gestureBuilder = GestureDescription.Builder().addStroke(stroke)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            gestureBuilder.setDisplayId(externalWindowManager.defaultDisplay.displayId)
        }

        dispatchGesture(gestureBuilder.build(), null, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
        if (::cursorView.isInitialized) externalWindowManager.removeView(cursorView)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}
    override fun onInterrupt() {}
}