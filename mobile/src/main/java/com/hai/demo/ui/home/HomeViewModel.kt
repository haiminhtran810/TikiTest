package com.hai.demo.ui.home

import androidx.lifecycle.MutableLiveData
import com.hai.data.usecase.GetKeyWordUseCase
import com.hai.demo.base.BaseViewModel
import com.hai.demo.extension.breakLineForString
import com.hai.demo.rx.SchedulerProvider

class HomeViewModel(
    private val schedulerProvider: SchedulerProvider,
    private val getKeyWordUseCase: GetKeyWordUseCase
) : BaseViewModel() {

    var listKeyWord = MutableLiveData<List<String>>()
    fun getKeyWord() {
        addDisposable(
            getKeyWordUseCase.createObservable()
                .subscribeOn(schedulerProvider.io())
                .observeOn(
                    schedulerProvider.ui()
                ).subscribe({
                    val newListData = arrayListOf<String>()
                    it.map {
                        newListData.add(it.breakLineForString())
                    }
                    listKeyWord.value = newListData
                }, {
                    val messageFail = it.message ?: ""
                })
        )
    }
}