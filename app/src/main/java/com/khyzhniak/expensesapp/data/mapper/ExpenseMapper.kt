package com.khyzhniak.expensesapp.data.mapper

import com.khyzhniak.expensesapp.data.local.entity.ExpenseWithCategory
import com.khyzhniak.expensesapp.domain.model.Expense

fun ExpenseWithCategory.toDomain(): Expense{
    return Expense(
        id = expense.id,
        title = expense.title,
        amount = expense.amount,
        dateMillis = expense.dateMillis,
        category = category.toDomain()
    )
}

