package com.hai.data.di

import com.hai.data.BuildConfig
import com.hai.data.di.Properties.TIME_OUT
import com.hai.data.repository.remote.TikiApi
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val netWorkModule = module {
    single(named("logging")) { createLoggingInterceptor() }
    single(named( "header")) { createHeaderInterceptor() }
    single { createOkHttpClient(get(named("logging")),get(named("header"))) }
    single { createAppRetrofit(get()) }
    single { createTikiApi(get()) }
}

object Properties {
    const val TIME_OUT = 10
}

fun createLoggingInterceptor(): Interceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
    return logging
}

fun createHeaderInterceptor(
): Interceptor {
    return Interceptor { chain ->
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header("Content-Type", "application/json")
            .method(request.method(), request.body())
            .build()
        chain.proceed(newRequest)
    }
}

fun createOkHttpClient(
    logging: Interceptor,
    header: Interceptor
): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        .addInterceptor(header)
        .addInterceptor(logging)
        .build()
}


fun createAppRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()
}

fun createTikiApi(retrofit: Retrofit): TikiApi {
    return retrofit.create(TikiApi::class.java)
}