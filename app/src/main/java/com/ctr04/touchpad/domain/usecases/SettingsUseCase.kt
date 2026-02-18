package com.ctr04.touchpad.domain.usecases

import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.KeyboardLanguage
import com.ctr04.touchpad.domain.entities.settings.AppearanceSettings
import com.ctr04.touchpad.domain.entities.settings.RemoteSettings
import com.ctr04.touchpad.domain.entities.settings.ThemeEntity
import com.ctr04.touchpad.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class SettingsUseCase(private val dataStoreRepository: DataStoreRepository) {

    // ---- Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings>
        get() = dataStoreRepository.appearanceSettingsFlow

    suspend fun saveTheme(themeEntity: ThemeEntity) {
        dataStoreRepository.saveTheme(themeEntity)
    }

    suspend fun saveUseDynamicColors(useDynamicColors: Boolean) {
        dataStoreRepository.saveUseDynamicColors(useDynamicColors)
    }

    suspend fun saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme: Boolean) {
        dataStoreRepository.saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme)
    }

    suspend fun saveUseFullScreen(useFullScreen: Boolean) {
        dataStoreRepository.saveUseFullScreen(useFullScreen)
    }

    // ---- Remote ----

    val remoteSettingsFlow: Flow<RemoteSettings>
        get() = dataStoreRepository.remoteSettingsFlow

    suspend fun saveMouseSpeed(mouseSpeed: Float) {
        dataStoreRepository.saveMouseSpeed(mouseSpeed)
    }

    suspend fun saveInvertMouseScrollingDirection(invertScrollingDirection: Boolean) {
        dataStoreRepository.saveInvertMouseScrollingDirection(invertScrollingDirection)
    }

    suspend fun saveUseGyroscope(useGyroscope: Boolean) {
        dataStoreRepository.saveUseGyroscope(useGyroscope)
    }

    suspend fun saveKeyboardLanguage(language: KeyboardLanguage) {
        dataStoreRepository.saveKeyboardLanguage(language)
    }

    suspend fun saveMustClearInputField(mustClearInputField: Boolean) {
        dataStoreRepository.saveMustClearInputField(mustClearInputField)
    }

    suspend fun saveUseAdvancedKeyboard(useAdvancedKeyboard: Boolean) {
        dataStoreRepository.saveUseAdvancedKeyboard(useAdvancedKeyboard)
    }

    suspend fun saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated: Boolean) {
        dataStoreRepository.saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated)
    }
}