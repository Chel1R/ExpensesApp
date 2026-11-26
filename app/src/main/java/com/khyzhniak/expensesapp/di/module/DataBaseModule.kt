package com.khyzhniak.expensesapp.di.module

import android.content.Context
import androidx.room.Room
import com.khyzhniak.expensesapp.data.local.dao.ExpensesDao
import com.khyzhniak.expensesapp.data.local.database.ExpensesDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context : Context
    ): ExpensesDataBase{
        return Room.databaseBuilder(
            context = context,
            klass = ExpensesDataBase::class.java,
            name = "ExpensesDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideExpensesDao(db : ExpensesDataBase): ExpensesDao{
        return db.expensesDao()
    }

}