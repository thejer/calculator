package io.budge.main.di

import dagger.Component
import io.budge.core.di.SubscriptionModule
import io.budge.main.ui.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SubscriptionModule::class,
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)
}