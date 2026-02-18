package com.ctr04.touchpad.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ctr04.touchpad.domain.entities.settings.AppearanceSettings
import com.ctr04.touchpad.domain.usecases.AppScopeUseCase
import kotlinx.coroutines.flow.Flow

class AppScopeViewModel(
    private val useCase: AppScopeUseCase
): ViewModel() {

    // ---- App Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings> = useCase.appearanceSettingsFlow
}