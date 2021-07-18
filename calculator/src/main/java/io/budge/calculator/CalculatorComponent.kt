package io.budge.calculator

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CalculatorModule::class])
interface CalculatorComponent {

    fun inject(calculatorActivity: CalculatorActivity)

}