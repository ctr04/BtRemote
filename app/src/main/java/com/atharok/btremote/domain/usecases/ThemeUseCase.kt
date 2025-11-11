package com.atharok.btremote.domain.usecases

import com.atharok.btremote.domain.entities.settings.AppearanceSettings
import com.atharok.btremote.domain.repositories.DataStoreRepository
import kotlinx.coroutines.flow.Flow

class ThemeUseCase(private val repository: DataStoreRepository) {
    val appearanceSettingsFlow: Flow<AppearanceSettings> get() = repository.appearanceSettingsFlow
}