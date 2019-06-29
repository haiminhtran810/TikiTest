package com.hai.data.repository

import com.hai.data.base.keywordData
import com.hai.data.repository.remote.TikiApi
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.InjectMocks
import org.mockito.Mock

@RunWith(JUnit4::class)
class TikiRepositoryImplTest : RepositoryUnitTest() {

    @Mock
    lateinit var tikiApi: TikiApi

    @InjectMocks
    lateinit var repository: TikiRepositoryImpl

    @Test
    fun getKeyword_Complete(){
        val response = keywordData()
        whenever(tikiApi.getKeyWord()).thenReturn(Single.just(response))
        val observer = repository.getKeyWord().test()
        verify(tikiApi).getKeyWord()

        observer.assertNoErrors()
        observer.assertValueCount(1)
        observer.assertComplete()
        observer.assertTerminated()
    }
}