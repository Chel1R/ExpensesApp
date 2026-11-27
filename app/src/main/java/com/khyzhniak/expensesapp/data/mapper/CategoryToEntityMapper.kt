package com.khyzhniak.expensesapp.data.mapper

import com.khyzhniak.expensesapp.data.local.entity.CategoryEntity
import com.khyzhniak.expensesapp.domain.model.Category

fun Category.toEntity(): CategoryEntity{
    return CategoryEntity(
        id = id,
        name = name,
        colorHex = colorHex
    )
}