package com.hai.data.di

import com.hai.data.usecase.GetKeyWordUseCase
import org.koin.dsl.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<GetKeyWordUseCase>()
}