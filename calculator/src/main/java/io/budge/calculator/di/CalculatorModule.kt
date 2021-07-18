package io.budge.calculator.di

import android.app.Application
import dagger.Module
import dagger.Provides
import io.budge.calculator.StringsProvider
import io.budge.calculator.usecase.SumUseCase
import javax.inject.Singleton

@Module
class CalculatorModule(
    val application: Application
) {

    @Provides
    @Singleton
    fun application(): Application = application

    @Provides
    @Singleton
    fun stringsProvider(
        application: Application
    ): StringsProvider = StringsProvider(application)

    @Singleton
    @Provides
    fun sumUseCase(
        stringsProvider: StringsProvider
    ): SumUseCase = SumUseCase(stringsProvider)
}