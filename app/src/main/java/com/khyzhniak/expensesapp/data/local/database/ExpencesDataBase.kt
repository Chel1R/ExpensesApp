package com.khyzhniak.expensesapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khyzhniak.expensesapp.data.local.dao.ExpensesDao
import com.khyzhniak.expensesapp.data.local.entity.ExpenseEntity


@Database(
    entities = [ExpenseEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ExpensesDataBase : RoomDatabase(){
    abstract fun expensesDao() : ExpensesDao
}