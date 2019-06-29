package com.hai.demo.viewmodel

import androidx.lifecycle.Observer
import com.hai.data.usecase.GetKeyWordUseCase
import com.hai.demo.base.ViewModelTest
import com.hai.demo.base.keywordData
import com.hai.demo.rx.SchedulerProvider
import com.hai.demo.ui.home.HomeViewModel
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert
import org.junit.Test
import org.mockito.Mock

class HomeViewModelTest : ViewModelTest() {
    @Mock
    private lateinit var getKeyWordUseCase: GetKeyWordUseCase

    @Mock
    private lateinit var schedulerProvider: SchedulerProvider

    @Mock
    private lateinit var viewModel: HomeViewModel

    override fun setUp() {
        super.setUp()
        getKeyWordUseCase = mock()
        schedulerProvider = mock()
        viewModel = HomeViewModel(schedulerProvider,getKeyWordUseCase)
    }

    @Test
    fun testGetKeyWord() {
        val originalLiveData = keywordData()
        val obs = mock<Observer<List<String>>>()
        viewModel.listKeyWord.observeForever(obs)
        Assert.assertEquals(viewModel.listKeyWord.value, originalLiveData)
    }
}