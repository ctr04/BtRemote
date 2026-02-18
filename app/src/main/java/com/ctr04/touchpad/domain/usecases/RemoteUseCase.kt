package com.ctr04.touchpad.domain.usecases

import com.ctr04.touchpad.domain.entities.settings.RemoteSettings
import com.ctr04.touchpad.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class RemoteUseCase(
    private val dataStoreRepository: DataStoreRepository
) {

    // ---- Settings ----

    val remoteSettingsFlow: Flow<RemoteSettings> get() = dataStoreRepository.remoteSettingsFlow
}