package com.brainstormideas.apptomar.data.remote.reposiories

import com.brainstormideas.apptomar.data.local.dao.UserDao
import com.brainstormideas.apptomar.data.local.entities.UserEntity
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.data.remote.services.UserService
import com.brainstormideas.apptomar.domain.models.toDomain
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserService,
    private var userDao: UserDao
) {

    suspend fun getAllUsersFromApi(): List<User>? {
        val response: List<User>? = api.getUsers()
        return response?.map { it.toDomain() }
    }

    suspend fun getUserFromApi(): User? {
        val response: User? = api.getUser()
        return response?.toDomain()
    }

    suspend fun getAllUsersFromDatabase(): List<User> {
        val response: List<UserEntity> = userDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getUserFromLocal(id: String?): User? {
        val response: UserEntity = userDao.findById(id)
        return response.toDomain()
    }

    suspend fun insertUsers(users: List<UserEntity>) {
        userDao.insertAll(users)
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun clearUsers() {
        userDao.deleteAllUsers()
    }

}