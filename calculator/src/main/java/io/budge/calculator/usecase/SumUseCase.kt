package io.budge.calculator.usecase

import io.budge.calculator.R
import io.budge.core.StringsProvider

class SumUseCase(
    val stringsProvider: StringsProvider
) {

    fun execute(firstNumber: Int, secondNumber: Int): Result {

        return if (firstNumber > 0 && secondNumber > 0)
            Result.Success(firstNumber + secondNumber)
        else Result.Failure(stringsProvider.getString(R.string.sum_case_error))
    }

    sealed class Result {
        class Success(val result: Int) : Result()
        class Failure(val message: String) : Result()
    }
}