package com.ctr04.touchpad.common.utils

import android.os.Build
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.KeyboardLanguage
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.AdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.BulgarianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.CzechAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.EnglishUKAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.EnglishUSAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.FrenchAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.GermanAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.GreekAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.HebrewAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PersianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PolishAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PortugueseAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PortugueseBRAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.RussianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.SpanishAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.TurkishAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.UkrainianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.BulgarianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.CzechVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.EnglishUKVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.EnglishUSVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.FrenchVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.GermanVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.GreekVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.HebrewVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PersianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PolishVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PortugueseBRVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PortugueseVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.RussianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.SpanishVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.TurkishVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.UkrainianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.VirtualKeyboardLayout
import org.koin.mp.KoinPlatform.getKoin

fun isDynamicColorsAvailable(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S

fun getKeyboardLayout(language: KeyboardLanguage): VirtualKeyboardLayout {
    return when(language) {
        KeyboardLanguage.ENGLISH_US -> getKoin().get<EnglishUSVirtualKeyboardLayout>()
        KeyboardLanguage.ENGLISH_UK -> getKoin().get<EnglishUKVirtualKeyboardLayout>()
        KeyboardLanguage.SPANISH -> getKoin().get<SpanishVirtualKeyboardLayout>()
        KeyboardLanguage.FRENCH -> getKoin().get<FrenchVirtualKeyboardLayout>()
        KeyboardLanguage.GERMAN -> getKoin().get<GermanVirtualKeyboardLayout>()
        KeyboardLanguage.RUSSIAN -> getKoin().get<RussianVirtualKeyboardLayout>()
        KeyboardLanguage.CZECH -> getKoin().get<CzechVirtualKeyboardLayout>()
        KeyboardLanguage.POLISH -> getKoin().get<PolishVirtualKeyboardLayout>()
        KeyboardLanguage.PORTUGUESE -> getKoin().get<PortugueseVirtualKeyboardLayout>()
        KeyboardLanguage.BRAZILIAN -> getKoin().get<PortugueseBRVirtualKeyboardLayout>()
        KeyboardLanguage.GREEK -> getKoin().get<GreekVirtualKeyboardLayout>()
        KeyboardLanguage.TURKISH -> getKoin().get<TurkishVirtualKeyboardLayout>()
        KeyboardLanguage.HEBREW -> getKoin().get<HebrewVirtualKeyboardLayout>()
        KeyboardLanguage.BULGARIAN -> getKoin().get<BulgarianVirtualKeyboardLayout>()
        KeyboardLanguage.UKRAINIAN -> getKoin().get<UkrainianVirtualKeyboardLayout>()
        KeyboardLanguage.PERSIAN -> getKoin().get<PersianVirtualKeyboardLayout>()
    }
}

fun getAdvancedKeyboardLayout(language: KeyboardLanguage): AdvancedKeyboardLayout {
    return when(language) {
        KeyboardLanguage.ENGLISH_US -> getKoin().get<EnglishUSAdvancedKeyboardLayout>()
        KeyboardLanguage.ENGLISH_UK -> getKoin().get<EnglishUKAdvancedKeyboardLayout>()
        KeyboardLanguage.SPANISH -> getKoin().get<SpanishAdvancedKeyboardLayout>()
        KeyboardLanguage.FRENCH -> getKoin().get<FrenchAdvancedKeyboardLayout>()
        KeyboardLanguage.GERMAN -> getKoin().get<GermanAdvancedKeyboardLayout>()
        KeyboardLanguage.RUSSIAN -> getKoin().get<RussianAdvancedKeyboardLayout>()
        KeyboardLanguage.CZECH -> getKoin().get<CzechAdvancedKeyboardLayout>()
        KeyboardLanguage.POLISH -> getKoin().get<PolishAdvancedKeyboardLayout>()
        KeyboardLanguage.PORTUGUESE -> getKoin().get<PortugueseAdvancedKeyboardLayout>()
        KeyboardLanguage.BRAZILIAN -> getKoin().get<PortugueseBRAdvancedKeyboardLayout>()
        KeyboardLanguage.GREEK -> getKoin().get<GreekAdvancedKeyboardLayout>()
        KeyboardLanguage.TURKISH -> getKoin().get<TurkishAdvancedKeyboardLayout>()
        KeyboardLanguage.HEBREW -> getKoin().get<HebrewAdvancedKeyboardLayout>()
        KeyboardLanguage.BULGARIAN -> getKoin().get<BulgarianAdvancedKeyboardLayout>()
        KeyboardLanguage.UKRAINIAN -> getKoin().get<UkrainianAdvancedKeyboardLayout>()
        KeyboardLanguage.PERSIAN -> getKoin().get<PersianAdvancedKeyboardLayout>()
    }
}

fun isMacAddress(macAddress: String): Boolean {
    val regex = "^([0-9A-Fa-f]{2}:){5}[0-9A-Fa-f]{2}$".toRegex()
    return macAddress.matches(regex)
}