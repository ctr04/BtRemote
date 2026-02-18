package com.ctr04.touchpad.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.KeyboardLanguage
import com.ctr04.touchpad.domain.entities.settings.AppearanceSettings
import com.ctr04.touchpad.domain.entities.settings.RemoteSettings
import com.ctr04.touchpad.domain.entities.settings.ThemeEntity
import com.ctr04.touchpad.domain.usecases.SettingsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val useCase: SettingsUseCase
): ViewModel() {

    // ---- Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings> = useCase.appearanceSettingsFlow

    fun changeTheme(newTheme: ThemeEntity) = viewModelScope.launch {
        useCase.saveTheme(newTheme)
    }

    fun setUseDynamicColors(useDynamicColors: Boolean) = viewModelScope.launch {
        useCase.saveUseDynamicColors(useDynamicColors)
    }

    fun setUseBlackColorForDarkTheme(useBlackColorForDarkTheme: Boolean) = viewModelScope.launch {
        useCase.saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme)
    }

    fun saveUseFullScreen(useFullScreen: Boolean) = viewModelScope.launch {
        useCase.saveUseFullScreen(useFullScreen)
    }

    // ---- Remote ----

    val remoteSettingsFlow: Flow<RemoteSettings> = useCase.remoteSettingsFlow

    fun saveMouseSpeed(mouseSpeed: Float) = viewModelScope.launch {
        useCase.saveMouseSpeed(mouseSpeed)
    }

    fun saveInvertMouseScrollingDirection(invertScrollingDirection: Boolean) = viewModelScope.launch {
        useCase.saveInvertMouseScrollingDirection(invertScrollingDirection)
    }

    fun saveUseGyroscope(useGyroscope: Boolean) = viewModelScope.launch {
        useCase.saveUseGyroscope(useGyroscope)
    }

    fun changeKeyboardLanguage(language: KeyboardLanguage) = viewModelScope.launch {
        useCase.saveKeyboardLanguage(language)
    }

    fun saveMustClearInputField(mustClearInputField: Boolean) = viewModelScope.launch {
        useCase.saveMustClearInputField(mustClearInputField)
    }

    fun saveUseAdvancedKeyboard(useAdvancedKeyboard: Boolean) = viewModelScope.launch {
        useCase.saveUseAdvancedKeyboard(useAdvancedKeyboard)
    }

    fun saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated: Boolean) = viewModelScope.launch {
        useCase.saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated)
    }
}