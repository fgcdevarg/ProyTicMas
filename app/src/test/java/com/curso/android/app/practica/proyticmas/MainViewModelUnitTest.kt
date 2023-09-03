package com.curso.android.app.practica.proyticmas

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.proyticmas.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    //instancia de viewModel
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTasRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value2 = viewModel.palabra.value?.estado
        assertEquals("", value2)
    }

    @Test
    fun mainViewModel_CheckCompararDistinto() = runTest {
        launch {
            viewModel.compararPalabras("Palabra1","Palabra2","")
        }
        advanceUntilIdle()
        val value2 = viewModel.palabra.value?.estado
        assertEquals("SON DISTINTAS", value2)
    }

    @Test
    fun mainViewModel_CheckCompararIguales() = runTest {
        launch {
            viewModel.compararPalabras("Palabra1","Palabra1","")
        }
        advanceUntilIdle()
        val value2 = viewModel.palabra.value?.estado
        assertEquals("SON IGUALES", value2)
    }

}