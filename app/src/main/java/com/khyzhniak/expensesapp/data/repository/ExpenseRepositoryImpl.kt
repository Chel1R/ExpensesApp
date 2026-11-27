package com.khyzhniak.expensesapp.data.repository

import com.khyzhniak.expensesapp.data.local.dao.ExpensesDao
import com.khyzhniak.expensesapp.data.mapper.toDomain
import com.khyzhniak.expensesapp.data.mapper.toEntity
import com.khyzhniak.expensesapp.domain.model.Expense
import com.khyzhniak.expensesapp.domain.repository.ExpenseRepository
import com.khyzhniak.expensesapp.domain.result.AppResult
import com.khyzhniak.expensesapp.domain.util.AppError
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExpenseRepositoryImpl @Inject constructor(
    private val dao : ExpensesDao
) : ExpenseRepository {
    override fun observeExpenses(): Flow<AppResult<List<Expense>, AppError.Local>> {
        return dao.observeExpensesWithCategory().map{
            list ->
            val result : AppResult<List<Expense>, AppError.Local> = AppResult.Success(list.map{it.toDomain()})
            result
        }.catch {
            emit(AppResult.Error(AppError.Local.Unknown))
        }
    }

    override fun observeExpensesByRange(startMilli: Long, endMilli: Long) : Flow<AppResult<List<Expense>, AppError.Local>>{
        return dao.observeExpensesByPeriod(startMilli,endMilli).map{
                list ->
            val result : AppResult<List<Expense>, AppError.Local> = AppResult.Success(list.map{it.toDomain()})
            result
        }.catch {
            emit(AppResult.Error(AppError.Local.Unknown))
        }
    }

    override suspend fun deleteExpense(id: Long): AppResult<Unit, AppError.Local> {
        return try {
            dao.deleteExpense(id)
            AppResult.Success(Unit)
        } catch (e: Exception){
            AppResult.Error(AppError.Local.Unknown)
        }
    }

    override suspend fun upsertExpense(expense: Expense): AppResult<Unit, AppError.Local> {
        return try{
            dao.upsertExpense(expense.toEntity())
            AppResult.Success(Unit)
        } catch (e : Exception){
            AppResult.Error(AppError.Local.Unknown)
        }
    }
}