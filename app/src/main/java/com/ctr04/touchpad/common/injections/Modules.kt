package com.ctr04.touchpad.common.injections

import android.content.Context
import android.hardware.SensorManager
import android.hardware.display.DisplayManager
import com.ctr04.touchpad.data.dataStore.SettingsDataStore
import com.ctr04.touchpad.data.repositories.DataStoreRepositoryImpl
import com.ctr04.touchpad.data.repositories.GyroscopeSensorRepositoryImpl
import com.ctr04.touchpad.data.sensor.GyroscopeSensor
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.BulgarianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.CzechAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.EnglishUKAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.EnglishUSAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.FrenchAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.GermanAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.GreekAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.HebrewAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PersianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PolishAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PortugueseAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.PortugueseBRAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.RussianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.SpanishAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.TurkishAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.advancedKeyboard.UkrainianAdvancedKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.BulgarianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.CzechVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.EnglishUKVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.EnglishUSVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.FrenchVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.GermanVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.GreekVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.HebrewVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PersianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PolishVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PortugueseBRVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.PortugueseVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.RussianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.SpanishVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.TurkishVirtualKeyboardLayout
import com.ctr04.touchpad.domain.entities.remoteInput.keyboard.virtualKeyboard.UkrainianVirtualKeyboardLayout
import com.ctr04.touchpad.domain.repositories.DataStoreRepository
import com.ctr04.touchpad.domain.repositories.GyroscopeSensorRepository
import com.ctr04.touchpad.domain.usecases.AppScopeUseCase
import com.ctr04.touchpad.domain.usecases.GyroscopeSensorUseCase
import com.ctr04.touchpad.domain.usecases.RemoteUseCase
import com.ctr04.touchpad.domain.usecases.SettingsUseCase
import com.ctr04.touchpad.presentation.viewmodel.AppScopeViewModel
import com.ctr04.touchpad.presentation.viewmodel.GyroscopeSensorViewModel
import com.ctr04.touchpad.presentation.viewmodel.RemoteViewModel
import com.ctr04.touchpad.presentation.viewmodel.SettingsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import java.util.Locale

val appModules by lazy {
    listOf<Module>(androidModule, viewModelModule, useCaseModule, repositoryModule, dataModule)
}

private val androidModule: Module = module {
    single<SensorManager> {
        androidContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    single<DisplayManager> {
        androidContext().getSystemService(Context.DISPLAY_SERVICE) as DisplayManager
    }

    single { EnglishUSVirtualKeyboardLayout() }
    single { EnglishUKVirtualKeyboardLayout() }
    single { SpanishVirtualKeyboardLayout() }
    single { FrenchVirtualKeyboardLayout() }
    single { GermanVirtualKeyboardLayout() }
    single { RussianVirtualKeyboardLayout() }
    single { CzechVirtualKeyboardLayout() }
    single { PolishVirtualKeyboardLayout() }
    single { PortugueseVirtualKeyboardLayout() }
    single { PortugueseBRVirtualKeyboardLayout() }
    single { GreekVirtualKeyboardLayout() }
    single { TurkishVirtualKeyboardLayout() }
    single { HebrewVirtualKeyboardLayout() }
    single { BulgarianVirtualKeyboardLayout() }
    single { UkrainianVirtualKeyboardLayout() }
    single { PersianVirtualKeyboardLayout() }

    single { EnglishUSAdvancedKeyboardLayout(context = androidContext()) }
    single { EnglishUKAdvancedKeyboardLayout(context = androidContext()) }
    single { SpanishAdvancedKeyboardLayout(context = androidContext()) }
    single { FrenchAdvancedKeyboardLayout(context = androidContext()) }
    single { GermanAdvancedKeyboardLayout(context = androidContext()) }
    single { RussianAdvancedKeyboardLayout(context = androidContext()) }
    single { CzechAdvancedKeyboardLayout(context = androidContext()) }
    single { PolishAdvancedKeyboardLayout(context = androidContext()) }
    single { PortugueseAdvancedKeyboardLayout(context = androidContext()) }
    single { PortugueseBRAdvancedKeyboardLayout(context = androidContext()) }
    single { GreekAdvancedKeyboardLayout(context = androidContext()) }
    single { TurkishAdvancedKeyboardLayout(context = androidContext()) }
    single { HebrewAdvancedKeyboardLayout(context = androidContext()) }
    single { BulgarianAdvancedKeyboardLayout(context = androidContext()) }
    single { UkrainianAdvancedKeyboardLayout(context = androidContext()) }
    single { PersianAdvancedKeyboardLayout(context = androidContext()) }

    factory<Locale> {
        androidContext().resources.configuration.locales[0]
    }
}

private val viewModelModule: Module = module {
    viewModel {
        AppScopeViewModel(
            useCase = get<AppScopeUseCase>()
        )
    }

    viewModel {
        GyroscopeSensorViewModel(
            useCase = get<GyroscopeSensorUseCase>()
        )
    }

    viewModel {
        SettingsViewModel(
            useCase = get<SettingsUseCase>()
        )
    }

    viewModel {
        RemoteViewModel(
            useCase = get<RemoteUseCase>()
        )
    }
}

private val useCaseModule: Module = module {
    single {
        AppScopeUseCase(
            dataStoreRepository = get<DataStoreRepository>()
        )
    }

    single {
        GyroscopeSensorUseCase(
            repository = get<GyroscopeSensorRepository>()
        )
    }

    single {
        SettingsUseCase(
            dataStoreRepository = get<DataStoreRepository>()
        )
    }

    single {
        RemoteUseCase(
            dataStoreRepository = get<DataStoreRepository>()
        )
    }
}

private val repositoryModule: Module = module {
    single<GyroscopeSensorRepository> {
        GyroscopeSensorRepositoryImpl(
            sensor = get<GyroscopeSensor>()
        )
    }

    single<DataStoreRepository> {
        DataStoreRepositoryImpl(
            settingsDataStore = get<SettingsDataStore>()
        )
    }
}

private val dataModule: Module = module {
    single {
        GyroscopeSensor(
            sensorManager = get<SensorManager>(),
            displayManager = get<DisplayManager>()
        )
    }

    single {
        SettingsDataStore(
            context = androidContext()
        )
    }
}