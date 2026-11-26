package com.khyzhniak.expensesapp.domain.repository

import com.khyzhniak.expensesapp.domain.model.Expense
import com.khyzhniak.expensesapp.domain.result.AppResult
import com.khyzhniak.expensesapp.domain.util.AppError
import kotlinx.coroutines.flow.Flow

interface ExpenseRepository {
    fun observeExpenses(): Flow<AppResult<List<Expense>, AppError.Local>>

    fun observeExpensesByRange(startMilli : Long, endMilli : Long) : Flow<AppResult<List<Expense>,AppError.Local>>

    suspend fun upsertExpense(expense : Expense): AppResult<Unit, AppError.Local>

    suspend fun deleteExpense(id : Long) : AppResult<Unit, AppError.Local>
}