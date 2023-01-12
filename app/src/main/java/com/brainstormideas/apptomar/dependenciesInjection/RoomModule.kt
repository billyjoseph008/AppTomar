package com.brainstormideas.apptomar.dependenciesInjection

import android.content.Context
import androidx.room.Room
import com.brainstormideas.apptomar.data.local.StoreDatabase
import com.brainstormideas.apptomar.data.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val USER_DATABASE_NAME = "user_database"
    const val STORES_DATABASE_NAME = "stores_database"

    @Singleton
    @Provides
    fun provideUserRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UserDatabase::class.java, USER_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideStoresRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, StoreDatabase::class.java, STORES_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db: UserDatabase) = db.getUserDao()

    @Singleton
    @Provides
    fun provideStoreDao(db: StoreDatabase) = db.getStoreDao()
}