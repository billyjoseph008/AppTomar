package com.brainstormideas.apptomar.data.remote.services

import android.util.Log
import com.brainstormideas.apptomar.core.FirebaseFirestoreHelper
import com.brainstormideas.apptomar.data.models.Store
import com.brainstormideas.apptomar.data.remote.apiInterfaces.StoreApiClient
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class StoreService @Inject constructor() : StoreApiClient {

    private val firebase = FirebaseFirestoreHelper.getFireStoreDataBase()

    override suspend fun getStores(): List<Store>? {
        return try {
            println(
                firebase.collection("stores")
                    .get().await()
                    .documents
            )
            firebase.collection("stores")
                .get().await()
                .documents.mapNotNull { it.toObject(Store::class.java) }
        } catch (e: Exception) {
            Log.d("Error", "Firebase data not completed: $e")
            null
        }
    }
}