package com.hai.data.di

import com.google.gson.Gson
import com.hai.data.repository.TikiRepositoryImpl
import com.hai.data.repository.TikiRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { Gson() }
    single<TikiRepository> { TikiRepositoryImpl(get()) }
}