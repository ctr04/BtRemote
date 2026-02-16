package com.ctr04.btremote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ctr04.btremote.domain.entities.settings.AppearanceSettings
import com.ctr04.btremote.domain.usecases.AppScopeUseCase
import kotlinx.coroutines.flow.Flow

class AppScopeViewModel(
    private val useCase: AppScopeUseCase
): ViewModel() {

    // ---- App Appearance ----

    val appearanceSettingsFlow: Flow<AppearanceSettings> = useCase.appearanceSettingsFlow
}