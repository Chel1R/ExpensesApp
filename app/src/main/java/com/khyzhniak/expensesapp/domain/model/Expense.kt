package com.khyzhniak.expensesapp.domain.model

data class Expense(
    val id : Long,
    val title : String,
    val amount : Double,
    val dateMillis : Long,
    val category : Category,
)
