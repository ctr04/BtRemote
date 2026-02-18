package com.ctr04.touchpad.domain.usecases

import com.ctr04.touchpad.domain.entities.settings.AppearanceSettings
import com.ctr04.touchpad.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class AppScopeUseCase(
    private val dataStoreRepository: DataStoreRepository
) {

    // ---- App Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings> get() = dataStoreRepository.appearanceSettingsFlow
}