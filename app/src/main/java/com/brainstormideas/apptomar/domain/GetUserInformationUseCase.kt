package com.brainstormideas.apptomar.domain

import android.content.SharedPreferences
import com.brainstormideas.apptomar.data.local.entities.toEntity
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.data.remote.reposiories.UserRepository
import com.brainstormideas.apptomar.sessions.GlobalSession.userId
import javax.inject.Inject


class GetUserInformationUseCase @Inject constructor(private val repository: UserRepository) {

    private lateinit var preferences: SharedPreferences

    suspend operator fun invoke(): User? {

        val user = repository.getUserFromApi()
        return if (user != null) {
            repository.clearUsers()
            repository.insertUser(user.toEntity())
            user
        } else {
            repository.getUserFromLocal(preferences.userId)
        }
    }
}
