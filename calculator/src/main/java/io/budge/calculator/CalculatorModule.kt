package io.budge.calculator

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object CalculatorModule {

    @Singleton
    @Provides
    fun sumUseCase(): SumUseCase = SumUseCase()
}