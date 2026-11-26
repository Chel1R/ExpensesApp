package com.khyzhniak.expensesapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.khyzhniak.expensesapp.data.local.entity.ExpenseEntity
import com.khyzhniak.expensesapp.data.local.entity.ExpenseWithCategory
import com.khyzhniak.expensesapp.domain.model.Expense
import kotlinx.coroutines.flow.Flow


@Dao
interface ExpensesDao {
    @Transaction
    @Query("SELECT * FROM expenses ORDER BY dateMillis DESC")
    fun observeExpensesWithCategory(): Flow<List<ExpenseWithCategory>>

    @Transaction
    @Query("""
        SELECT * FROM expenses 
        WHERE dateMillis BETWEEN :startMillis AND :endMillis 
        ORDER BY dateMillis DESC""")
    fun observeExpensesByPeriod(startMillis: Long, endMillis : Long) : Flow<List<ExpenseWithCategory>>

    @Upsert
    suspend fun upsertExpense(expense: ExpenseEntity)

    @Delete
    suspend fun deleteExpense(id : Long)

}