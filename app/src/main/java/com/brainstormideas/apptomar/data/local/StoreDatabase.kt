package com.brainstormideas.apptomar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brainstormideas.apptomar.data.local.dao.StoreDao
import com.brainstormideas.apptomar.data.local.entities.StoreEntity

@Database(entities = [StoreEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class StoreDatabase : RoomDatabase() {
    abstract fun getStoreDao(): StoreDao
}