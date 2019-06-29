package com.hai.demo.di

import com.hai.demo.ui.MainViewModel
import com.hai.demo.ui.home.HomeViewModel
import org.koin.android.experimental.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<HomeViewModel>()
    viewModel<MainViewModel>()
}