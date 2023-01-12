package com.brainstormideas.apptomar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brainstormideas.apptomar.data.local.dao.UserDao
import com.brainstormideas.apptomar.data.local.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}