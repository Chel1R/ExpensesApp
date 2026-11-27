package com.khyzhniak.expensesapp.data.mapper

import com.khyzhniak.expensesapp.data.local.entity.ExpenseEntity
import com.khyzhniak.expensesapp.domain.model.Expense

fun Expense.toEntity(): ExpenseEntity{
    return ExpenseEntity(
        id = id,
        title = title,
        amount = amount,
        dateMillis = dateMillis,
        categoryId = category.id
    )
}