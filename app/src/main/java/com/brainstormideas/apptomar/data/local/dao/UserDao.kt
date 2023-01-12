package com.brainstormideas.apptomar.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.brainstormideas.apptomar.data.local.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users_table")
    suspend fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users_table WHERE id IN (:id)")
    suspend fun loadAllByIds(id: IntArray): List<UserEntity>

    @Query("SELECT * FROM users_table WHERE id IN (:id) LIMIT 1")
    suspend fun findById(id: String?): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Query("DELETE FROM users_table")
    suspend fun deleteAllUsers()
}