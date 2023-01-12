package com.brainstormideas.apptomar.data.remote.apiInterfaces

import com.brainstormideas.apptomar.data.models.Store

interface StoreApiClient {
    suspend fun getStores(): List<Store>?
}