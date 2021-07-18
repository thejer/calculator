package io.budge.main

import android.app.Application
import io.budge.calculator.di.CalculatorComponent
import io.budge.calculator.di.DaggerCalculatorComponent
import io.budge.calculator.di.providers.CalculatorComponentProvider
import io.budge.core.di.CoreModule
import io.budge.main.di.ApplicationComponent
import io.budge.main.di.ApplicationComponentProvider
import io.budge.main.di.DaggerApplicationComponent

class App : Application(),
    CalculatorComponentProvider,
    ApplicationComponentProvider {

    private val coreModule: CoreModule by lazy {
        CoreModule(this)
    }

    override fun getCalculatorComponent(): CalculatorComponent =
        DaggerCalculatorComponent
        .builder()
        .coreModule(coreModule)
        .build()

    override fun getApplicationComponent(): ApplicationComponent =
        DaggerApplicationComponent.builder()
        .coreModule(coreModule)
        .build()

}