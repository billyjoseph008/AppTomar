package com.brainstormideas.apptomar.domain

import com.brainstormideas.apptomar.data.local.entities.toDatabase
import com.brainstormideas.apptomar.data.models.Store
import com.brainstormideas.apptomar.data.remote.reposiories.StoreRepository
import javax.inject.Inject

class GetStoresUseCase @Inject constructor(private val repository: StoreRepository) {
    suspend operator fun invoke(): List<Store> {
        val stores = repository.getAllStoresFromApi()
        return if (stores?.isNotEmpty()!!) {
            repository.clearStores()
            repository.insertStores(stores.map { it.toDatabase() })
            stores
        } else {
            repository.getAllStoresFromDatabase()
        }
    }
}