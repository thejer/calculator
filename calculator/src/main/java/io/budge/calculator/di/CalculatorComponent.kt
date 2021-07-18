package io.budge.calculator.di

import dagger.Component
import io.budge.calculator.ui.CalculatorActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [CalculatorModule::class])
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}