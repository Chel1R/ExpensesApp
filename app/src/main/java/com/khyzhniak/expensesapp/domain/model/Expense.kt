package com.khyzhniak.expensesapp.domain.model

data class Expense(
    val id : Int,
    val title : String,
    val amount : Double,
    val dateMillis : Long,
    val categoryId : Long,
)
