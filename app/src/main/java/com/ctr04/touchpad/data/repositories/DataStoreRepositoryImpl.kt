package com.ctr04.touchpad.data.repositories

import com.ctr04.touchpad.data.dataStore.SettingsDataStore
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.KeyboardLanguage
import com.ctr04.touchpad.domain.entities.settings.AppearanceSettings
import com.ctr04.touchpad.domain.entities.settings.RemoteSettings
import com.ctr04.touchpad.domain.entities.settings.ThemeEntity
import com.ctr04.touchpad.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class DataStoreRepositoryImpl(
    private val settingsDataStore: SettingsDataStore
): DataStoreRepository {

    // ---- Appearance ----

    override val appearanceSettingsFlow: Flow<AppearanceSettings>
        get() = settingsDataStore.appearanceSettingsFlow

    override suspend fun saveTheme(themeEntity: ThemeEntity) {
        settingsDataStore.saveTheme(themeEntity)
    }

    override suspend fun saveUseDynamicColors(useDynamicColors: Boolean) {
        settingsDataStore.saveUseDynamicColors(useDynamicColors)
    }

    override suspend fun saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme: Boolean) {
        settingsDataStore.saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme)
    }

    override suspend fun saveUseFullScreen(useFullScreen: Boolean) {
        settingsDataStore.saveUseFullScreen(useFullScreen)
    }

    // ---- Remote ----

    override val remoteSettingsFlow: Flow<RemoteSettings>
        get() = settingsDataStore.remoteSettingsFlow

    override suspend fun saveMouseSpeed(mouseSpeed: Float) {
        settingsDataStore.saveMouseSpeed(mouseSpeed)
    }

    override suspend fun saveInvertMouseScrollingDirection(invertScrollingDirection: Boolean) {
        settingsDataStore.saveInvertMouseScrollingDirection(invertScrollingDirection)
    }

    override suspend fun saveUseGyroscope(useGyroscope: Boolean) {
        settingsDataStore.saveUseGyroscope(useGyroscope)
    }

    override suspend fun saveKeyboardLanguage(language: KeyboardLanguage) {
        settingsDataStore.saveKeyboardLanguage(language)
    }

    override suspend fun saveMustClearInputField(mustClearInputField: Boolean) {
        settingsDataStore.saveMustClearInputField(mustClearInputField)
    }

    override suspend fun saveUseAdvancedKeyboard(useAdvancedKeyboard: Boolean) {
        settingsDataStore.saveUseAdvancedKeyboard(useAdvancedKeyboard)
    }

    override suspend fun saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated: Boolean) {
        settingsDataStore.saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated)
    }
}