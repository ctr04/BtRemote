package com.ctr04.btremote.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ctr04.btremote.domain.usecases.GyroscopeSensorUseCase
import kotlinx.coroutines.flow.StateFlow

class GyroscopeSensorViewModel(
    private val useCase: GyroscopeSensorUseCase
): ViewModel() {

    fun startListening() {
        useCase.startListening()
    }

    fun stopListening() {
        useCase.stopListening()
    }

    fun getDisplayRotation(): Int = useCase.getDisplayRotation()

    val positions: StateFlow<Triple<Float, Float, Float>> get() = useCase.getPositions()
}