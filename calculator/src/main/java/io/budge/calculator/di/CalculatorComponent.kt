package io.budge.calculator.di

import dagger.Component
import io.budge.calculator.ui.CalculatorActivity
import io.budge.core.di.CoreModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CalculatorModule::class,
        CoreModule::class
    ]
)
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}