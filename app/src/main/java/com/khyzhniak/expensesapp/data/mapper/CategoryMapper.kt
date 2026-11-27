package com.khyzhniak.expensesapp.data.mapper

import com.khyzhniak.expensesapp.data.local.entity.CategoryEntity
import com.khyzhniak.expensesapp.domain.model.Category

fun CategoryEntity.toDomain(): Category{
    return Category(
        id = id,
        name = name,
        colorHex = colorHex
    )
}