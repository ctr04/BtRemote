package com.ctr04.touchpad.domain.entities.settings

import androidx.annotation.StringRes
import com.ctr04.touchpad.R

enum class ThemeEntity(@param:StringRes val stringRes: Int) {
    SYSTEM(R.string.theme_system),
    LIGHT(R.string.theme_light),
    DARK(R.string.theme_dark)
}