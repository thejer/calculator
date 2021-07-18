package io.budge.core.di

import android.app.Application
import dagger.Module
import dagger.Provides
import io.budge.core.resources.StringsProvider
import javax.inject.Singleton

@Module
class CoreModule(
    val application: Application
) {

    @Provides
    @Singleton
    fun stringsProvider() = StringsProvider(application)
}