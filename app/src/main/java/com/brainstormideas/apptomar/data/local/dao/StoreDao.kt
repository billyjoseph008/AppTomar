package com.brainstormideas.apptomar.data.local.dao

import androidx.room.*
import com.brainstormideas.apptomar.data.local.entities.StoreEntity

@Dao
interface StoreDao {

    @Query("SELECT * FROM stores_table")
    suspend fun getAll(): List<StoreEntity>

    @Query("SELECT * FROM stores_table WHERE id IN (:id)")
    suspend fun loadAllByIds(id: IntArray): List<StoreEntity>

    @Query("SELECT * FROM stores_table WHERE name LIKE :first LIKE :last LIMIT 1")
    suspend fun findByName(first: String, last: String): StoreEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<StoreEntity>)

    @Query("DELETE FROM stores_table")
    suspend fun deleteAllQuotes()

}
