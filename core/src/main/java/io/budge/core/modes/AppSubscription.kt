package io.budge.core.modes

import io.budge.core.R
import io.budge.core.resources.StringsProvider

class AppSubscription (
    private val stringsProvider: StringsProvider
) {
    fun getUserSubscription() = stringsProvider.getString(R.string.free_mode)
}