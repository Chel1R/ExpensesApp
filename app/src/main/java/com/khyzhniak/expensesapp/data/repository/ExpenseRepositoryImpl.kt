package com.khyzhniak.expensesapp.data.repository

import com.khyzhniak.expensesapp.data.local.dao.ExpensesDao
import com.khyzhniak.expensesapp.domain.model.Expense
import com.khyzhniak.expensesapp.domain.repository.ExpenseRepository
import com.khyzhniak.expensesapp.domain.result.AppResult
import com.khyzhniak.expensesapp.domain.util.AppError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val dao : ExpensesDao
) : ExpenseRepository {
    override fun observeExpenses(): Flow<AppResult<List<Expense>, AppError.Local>> {
        TODO("Not yet implemented")
    }

    override fun observeExpensesByRange(startMilli: Long, endMilli: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteExpense(id: Long): AppResult<Unit, AppError.Local> {
        TODO("Not yet implemented")
    }

    override suspend fun upsertExpense(expense: Expense): AppResult<Unit, AppError.Local> {
        TODO("Not yet implemented")
    }
}