package com.ctr04.touchpad.ui.screens

import android.content.Intent
import android.provider.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.LifecycleResumeEffect
import com.ctr04.touchpad.data.service.MyTouchpadService
import com.ctr04.touchpad.R
import com.ctr04.touchpad.common.utils.AppIcons
import com.ctr04.touchpad.common.utils.isAccessibilityServiceEnabled
import com.ctr04.touchpad.ui.views.ActivationView

@Composable
fun AccessibilityPermissionsScreen(
    onPermissionsGranted: () -> Unit,
    navigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isServiceEnabled by remember {
        mutableStateOf(isAccessibilityServiceEnabled(context, MyTouchpadService::class.java))
    }

    LifecycleResumeEffect(Unit) {
        isServiceEnabled = isAccessibilityServiceEnabled(context, MyTouchpadService::class.java)

        onPauseOrDispose {
        }
    }

    if(isServiceEnabled) {
        LaunchedEffect(Unit) {
            onPermissionsGranted()
        }
    } else {
        ActivationView(
            topBarTitle = stringResource(id = R.string.permission),
            image = AppIcons.Lock,
            title = stringResource(id = R.string.accessibility_permission_not_granted),
            message = stringResource(id = R.string.accessibility_permission_message),
            buttonIcon = AppIcons.Key,
            buttonText = stringResource(id = R.string.accessibility_permission_button),
            buttonOnClick = {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                context.startActivity(intent)
            },
            hideButton = false,
            navigateToSettings = navigateToSettings,
            modifier = modifier
        )
    }
}
