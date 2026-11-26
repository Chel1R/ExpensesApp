package com.khyzhniak.expensesapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index


@Entity(
    tableName = "expenses",
    primaryKeys = ["id"],
    foreignKeys = [
        ForeignKey(
            entity = CategoryEntity::class,
            parentColumns = ["id"],
            childColumns = ["categoryId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("categoryId")]
)
data class ExpenseEntity(
    val id : Int,
    val title : String,
    val amount : Double,
    val dateMillis : Long,
    val categoryId : Long,
)
