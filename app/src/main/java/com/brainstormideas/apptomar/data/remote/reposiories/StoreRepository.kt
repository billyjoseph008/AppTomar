package com.brainstormideas.apptomar.data.remote.reposiories

import com.brainstormideas.apptomar.data.local.dao.StoreDao
import com.brainstormideas.apptomar.data.local.entities.StoreEntity
import com.brainstormideas.apptomar.data.models.Store
import com.brainstormideas.apptomar.data.remote.services.StoreService
import com.brainstormideas.apptomar.domain.models.toDomain
import javax.inject.Inject

class StoreRepository @Inject constructor(
    private val api: StoreService,
    private val storeDao: StoreDao
) {
    suspend fun getAllStoresFromApi(): List<Store>? {
        val response: List<Store>? = api.getStores()
        return response?.map { it.toDomain() }
    }

    suspend fun getAllStoresFromDatabase(): List<Store> {
        val response: List<StoreEntity> = storeDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun insertStores(stores: List<StoreEntity>) {
        storeDao.insertAll(stores)
    }

    suspend fun clearStores() {
        storeDao.deleteAllQuotes()
    }

}