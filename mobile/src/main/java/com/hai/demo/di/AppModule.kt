package com.hai.demo.di

import com.hai.data.di.entityMapperModule
import com.hai.data.di.netWorkModule
import com.hai.data.di.repositoryModule
import com.hai.data.di.useCaseModule
import com.hai.demo.rx.AppSchedulerProvider
import com.hai.demo.rx.SchedulerProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


val appModule = module {
    single { androidApplication().resources }
    single<SchedulerProvider> { AppSchedulerProvider() }
}

val modules = listOf(
    appModule,
    entityMapperModule,
    netWorkModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)