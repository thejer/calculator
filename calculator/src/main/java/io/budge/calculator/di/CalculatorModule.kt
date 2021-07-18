package io.budge.calculator.di

import dagger.Module
import dagger.Provides
import io.budge.calculator.usecase.SumUseCase
import io.budge.core.StringsProvider
import javax.inject.Singleton

@Module
object CalculatorModule{

    @Singleton
    @Provides
    fun sumUseCase(
        stringsProvider: StringsProvider
    ): SumUseCase = SumUseCase(stringsProvider)
}