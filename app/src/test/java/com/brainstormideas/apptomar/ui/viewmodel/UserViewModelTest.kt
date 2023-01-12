package com.brainstormideas.apptomar.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.brainstormideas.apptomar.data.models.User
import com.brainstormideas.apptomar.domain.GetUserInformationUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class UserViewModelTest {

    @RelaxedMockK
    private lateinit var getUserInformationUseCase: GetUserInformationUseCase

    @RelaxedMockK
    private lateinit var userViewModel: UserViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        userViewModel = UserViewModel(getUserInformationUseCase)
        Dispatchers.setMain(
            Dispatchers.Unconfined
        )
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }

    @Test
    fun `when viewmodel is created at the first  time, get all  quotes and set the first value`() =
        runTest {
            //Given
            val user = User(
                0, "", "", "", "", "", "", "", "",
                "", "", "", ""
            )
            coEvery { getUserInformationUseCase() } returns user

            //When
            userViewModel.onCreate()

            //Then
            assert(userViewModel.userModel.value == user)

        }

}

