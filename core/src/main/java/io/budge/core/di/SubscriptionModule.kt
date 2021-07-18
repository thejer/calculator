package io.budge.core.di

import dagger.Module
import dagger.Provides
import io.budge.core.modes.AppSubscription
import io.budge.core.resources.StringsProvider
import javax.inject.Singleton

@Module(
    includes = [
        CoreModule::class
    ]
)
object SubscriptionModule {

    @Provides
    @Singleton
    fun appSubscription(
        stringsProvider: StringsProvider
    ) = AppSubscription(stringsProvider)
}