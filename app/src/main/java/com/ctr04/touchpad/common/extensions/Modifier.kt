package com.ctr04.touchpad.common.extensions

import android.util.LayoutDirection
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.core.text.layoutDirection
import com.ctr04.touchpad.common.utils.AppIcons.Help
import com.ctr04.touchpad.common.utils.AppIcons.Mute
import com.ctr04.touchpad.common.utils.AppIcons.VolumeDown
import com.ctr04.touchpad.common.utils.AppIcons.VolumeUp
import com.ctr04.touchpad.common.utils.AppIcons.getKoin
import java.util.Locale

// Workaround for some icons which should not be mirrored in RTL layout.
fun Modifier.autoMirroredIcon(icon: ImageVector): Modifier {
    when (icon) {
        Help -> {
            if (getKoin().get<Locale>().language == Locale.forLanguageTag("he").language) {
                return this.scale(scaleX = -1f, scaleY = 1f)
            }
        }

        Mute, VolumeUp, VolumeDown -> {
            if (getKoin().get<Locale>().layoutDirection == LayoutDirection.RTL) {
                return this.scale(scaleX = -1f, scaleY = 1f)
            }
        }
    }
    return this
}