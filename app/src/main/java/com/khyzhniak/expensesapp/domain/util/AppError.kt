package com.khyzhniak.expensesapp.domain.util

sealed interface AppError {
    sealed interface Network : AppError{
        data object NoInternet : Network
        data object Timeout : Network
        data object Unauthorized : Network
        data object ServerError : Network
        data object Unknown : Network
    }

    sealed interface Local : AppError {
        data object DiskFull : Local
        data object NotFound : Local
        data object Unknown : Local
    }

    sealed interface Validation : AppError {
        data object EmptyTitle : Validation
        data object InvalidAmount : Validation
    }
}