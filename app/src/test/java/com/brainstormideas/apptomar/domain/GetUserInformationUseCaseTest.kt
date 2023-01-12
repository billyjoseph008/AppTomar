package com.brainstormideas.apptomar.domain

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.data.remote.reposiories.UserRepository
import com.brainstormideas.apptomar.sessions.GlobalSession
import com.brainstormideas.apptomar.ui.screens.GLOBAL_PREFERENCE
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

internal class GetUserInformationUseCaseTest {

    @RelaxedMockK
    private lateinit var userRepository: UserRepository
    private lateinit var sharedPreferences: SharedPreferences

    lateinit var getUserInformationUseCase: GetUserInformationUseCase

    @Before
    fun onBefore() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        MockKAnnotations.init(this)
        getUserInformationUseCase = GetUserInformationUseCase(userRepository)
        sharedPreferences = GlobalSession.customPreference(context, GLOBAL_PREFERENCE)
    }

    @Test
    fun `when the api doesnt return anything then get values from dataBase`() = runBlocking {
        //Given
        coEvery {
            userRepository.getUserFromApi()
        } returns null

        //When
        getUserInformationUseCase()

        //Then
        coVerify(exactly = 1) { userRepository.getUserFromLocal("Any") }
    }

    @Test
    fun `when the api returns somoethiing then get values from api`() = runBlocking {
        //Given
        val user = User(
            0, "", "", "", "", "", "", "", "",
            "", "", "", ""
        )
        coEvery { userRepository.getUserFromApi() } returns user

        //When
        val response = getUserInformationUseCase()

        //Then
        coVerify(exactly = 1) {
            userRepository.clearUsers()
        }
        coVerify(exactly = 1) {
            userRepository.insertUser(any())
        }
        coVerify(exactly = 0) {
            userRepository.getUserFromLocal("Any")
        }
        assert(user == response)

    }
}