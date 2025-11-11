package com.atharok.btremote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.atharok.btremote.domain.entities.settings.AppearanceSettings
import com.atharok.btremote.domain.usecases.ThemeUseCase
import kotlinx.coroutines.flow.Flow

class ThemeViewModel(
    private val useCase: ThemeUseCase
): ViewModel() {
    val appearanceSettingsFlow: Flow<AppearanceSettings> = useCase.appearanceSettingsFlow
}