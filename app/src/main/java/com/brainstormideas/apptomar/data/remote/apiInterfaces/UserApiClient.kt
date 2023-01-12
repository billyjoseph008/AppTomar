package com.brainstormideas.apptomar.data.remote.apiInterfaces

import com.brainstormideas.apptomar.data.models.User

interface UserApiClient {
    suspend fun getUsers(): List<User>?
    suspend fun getUser(): User?
}