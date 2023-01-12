package com.brainstormideas.apptomar.data.remote.services

import android.util.Log
import com.brainstormideas.apptomar.core.FirebaseAuthHelper
import com.brainstormideas.apptomar.core.FirebaseFirestoreHelper
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.data.models.User.Companion.toUser
import com.brainstormideas.apptomar.data.remote.apiInterfaces.UserApiClient
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class UserService @Inject constructor() : UserApiClient {

    private val firebase = FirebaseFirestoreHelper.getFireStoreDataBase()
    private val userId = FirebaseAuthHelper().getCurrentUser()?.uid.toString()

    override suspend fun getUsers(): List<User>? {
        return try {
            firebase.collection("users")
                .get().await()
                .documents.mapNotNull { it.toObject(User::class.java) }
        } catch (e: Exception) {
            Log.d("Error", "Firebase data not completed: $e")
            null
        }
    }

    override suspend fun getUser(): User? {
        return try {
            firebase.collection("users")
                .document(userId).get().await().toUser()
        } catch (e: Exception) {
            Log.d("Error", "Firebase data not completed: $e")
            null
        }
    }
}
