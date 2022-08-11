package com.jcampusano.customersdirectory.di

import android.content.Context
import androidx.room.Room
import com.jcampusano.customersdirectory.data.database.BusinessDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val BUSINESS_DATABASE_DAO = "business_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, BusinessDatabase::class.java, BUSINESS_DATABASE_DAO)
            .build()

    @Singleton
    @Provides
    fun provideBusinessDao(db: BusinessDatabase) = db.getBusinessDao()
}