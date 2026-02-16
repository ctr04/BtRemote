package com.ctr04.btremote.domain.usecases

import com.ctr04.btremote.domain.entities.DeviceHidConnectionState
import com.ctr04.btremote.domain.entities.settings.AppearanceSettings
import com.ctr04.btremote.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

class AppScopeUseCase(
    private val dataStoreRepository: DataStoreRepository
) {

    // ---- App Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings> get() = dataStoreRepository.appearanceSettingsFlow
}