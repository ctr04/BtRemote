package com.ctr04.touchpad.common.utils

import android.Manifest
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import android.view.accessibility.AccessibilityManager
import com.ctr04.touchpad.MyTouchpadService

val accessibilityPermission: Array<String> by lazy {
    arrayOf(
        Manifest.permission.BIND_ACCESSIBILITY_SERVICE,
    )
}

fun isAccessibilityServiceEnabled(context: Context, service: Class<*>): Boolean {
    val am = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
    val enabledServices = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)

    for (enabledService in enabledServices) {
        val enabledServiceInfo = enabledService.resolveInfo.serviceInfo
        if (enabledServiceInfo.packageName == context.packageName &&
            enabledServiceInfo.name == service.name) {
            return true
        }
    }
    return false
}

fun arePermissionsGranted(context: Context, permissions: Array<String>): Boolean {
    return permissions.all {permission ->
        when (permission) {
            Manifest.permission.POST_NOTIFICATIONS -> true // Not mandatory
            Manifest.permission.BIND_ACCESSIBILITY_SERVICE -> {
                isAccessibilityServiceEnabled(context, MyTouchpadService::class.java)
            }
            else -> ActivityCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }
    }
}

fun arePermissionsGranted(permissions: Map<String, Boolean>): Boolean {
    return permissions.all {
        if(it.key == Manifest.permission.POST_NOTIFICATIONS) // Not mandatory
            true
        else it.value
    }
}