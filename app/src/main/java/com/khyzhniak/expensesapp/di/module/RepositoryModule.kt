package com.khyzhniak.expensesapp.di.module

import com.khyzhniak.expensesapp.data.repository.ExpenseRepositoryImpl
import com.khyzhniak.expensesapp.domain.repository.ExpenseRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
abstract class  RepositoryModule {
    @Binds
    abstract fun bindExpenseRepository(
        expenseRepositoryImpl: ExpenseRepository
    ): ExpenseRepository
}