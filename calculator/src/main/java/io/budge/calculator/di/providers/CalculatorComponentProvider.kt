package io.budge.calculator.di.providers

import io.budge.calculator.di.CalculatorComponent

interface CalculatorComponentProvider {

  fun getCalculatorComponent(): CalculatorComponent

}