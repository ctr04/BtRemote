package com.ctr04.touchpad.ui.screens

import android.content.Intent
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.ctr04.touchpad.R
import com.ctr04.touchpad.common.utils.AppIcons
import com.ctr04.touchpad.common.utils.arePermissionsGranted
import com.ctr04.touchpad.ui.views.ActivationView

@Composable
fun AccessibilityPermissionsScreen(
    permissions: Array<String>,
    arePermissionsGranted: Boolean,
    onPermissionsGranted: () -> Unit,
    navigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    val permissionState = remember { mutableStateOf(arePermissionsGranted) }
    val context = LocalContext.current

    if(permissionState.value) {
        LaunchedEffect(Unit) {
            onPermissionsGranted()
        }
    } else {
        var shouldAskPermissions: Boolean by remember { mutableStateOf(false) }

        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestMultiplePermissions(),
            onResult = { result: Map<String, Boolean> ->
                shouldAskPermissions = false
                permissionState.value = arePermissionsGranted(result)
            }
        )

        LaunchedEffect(shouldAskPermissions) {
            if(shouldAskPermissions) {
                launcher.launch(permissions)
            }
        }

        ActivationView(
            topBarTitle = stringResource(id = R.string.permission),
            image = AppIcons.Lock,
            title = stringResource(id = R.string.accessibility_permission_not_granted),
            message = stringResource(id = R.string.accessibility_permission_message),
            buttonIcon = AppIcons.Key,
            buttonText = stringResource(id = R.string.accessibility_permission_button),
            buttonOnClick = {
                val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
                context.startActivity(intent)
            },
            hideButton = false,
            navigateToSettings = navigateToSettings,
            modifier = modifier
        )
    }
}
