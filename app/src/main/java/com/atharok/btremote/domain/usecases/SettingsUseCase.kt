package com.atharok.btremote.domain.usecases

import com.atharok.btremote.domain.entities.RemoteNavigationEntity
import com.atharok.btremote.domain.entities.remoteInput.keyboard.KeyboardLanguage
import com.atharok.btremote.domain.entities.settings.AppearanceSettings
import com.atharok.btremote.domain.entities.settings.RemoteSettings
import com.atharok.btremote.domain.entities.settings.ThemeEntity
import com.atharok.btremote.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class SettingsUseCase(private val repository: DataStoreRepository) {

    // ---- Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings>
        get() = repository.appearanceSettingsFlow

    suspend fun saveTheme(themeEntity: ThemeEntity) {
        repository.saveTheme(themeEntity)
    }

    suspend fun saveUseDynamicColors(useDynamicColors: Boolean) {
        repository.saveUseDynamicColors(useDynamicColors)
    }

    suspend fun saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme: Boolean) {
        repository.saveUseBlackColorForDarkTheme(useBlackColorForDarkTheme)
    }

    suspend fun saveUseFullScreen(useFullScreen: Boolean) {
        repository.saveUseFullScreen(useFullScreen)
    }

    // ---- Remote ----

    val remoteSettingsFlow: Flow<RemoteSettings>
        get() = repository.remoteSettingsFlow

    suspend fun saveMouseSpeed(mouseSpeed: Float) {
        repository.saveMouseSpeed(mouseSpeed)
    }

    suspend fun saveInvertMouseScrollingDirection(invertScrollingDirection: Boolean) {
        repository.saveInvertMouseScrollingDirection(invertScrollingDirection)
    }

    suspend fun saveUseGyroscope(useGyroscope: Boolean) {
        repository.saveUseGyroscope(useGyroscope)
    }

    suspend fun saveKeyboardLanguage(language: KeyboardLanguage) {
        repository.saveKeyboardLanguage(language)
    }

    suspend fun saveMustClearInputField(mustClearInputField: Boolean) {
        repository.saveMustClearInputField(mustClearInputField)
    }

    suspend fun saveUseAdvancedKeyboard(useAdvancedKeyboard: Boolean) {
        repository.saveUseAdvancedKeyboard(useAdvancedKeyboard)
    }

    suspend fun saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated: Boolean) {
        repository.saveUseAdvancedKeyboardIntegrated(useAdvancedKeyboardIntegrated)
    }

    suspend fun saveUseMinimalistRemote(useMinimalistRemote: Boolean) {
        repository.saveUseMinimalistRemote(useMinimalistRemote)
    }

    suspend fun saveRemoteNavigation(remoteNavigationEntity: RemoteNavigationEntity) {
        repository.saveRemoteNavigation(remoteNavigationEntity)
    }

    suspend fun saveUseEnterForSelection(useEnterForSelection: Boolean) {
        repository.saveUseEnterForSelection(useEnterForSelection)
    }

    // ---- Others ----

    fun getFavoriteDevices(): Flow<List<String>> = repository.getFavoriteDevices()
    suspend fun saveFavoriteDevices(macAddresses: List<String>) {
        repository.saveFavoriteDevices(macAddresses)
    }

    fun hideBluetoothActivationButton(): Flow<Boolean> = repository.hideBluetoothActivationButton()
    suspend fun saveHideBluetoothActivationButton(hide: Boolean) {
        repository.saveHideBluetoothActivationButton(hide)
    }
}