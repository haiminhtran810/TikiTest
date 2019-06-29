package com.hai.data.repository.remote

import io.reactivex.Single
import retrofit2.http.GET

interface TikiApi {
    @GET("v2/keywords.json")
    fun getKeyWord(): Single<List<String>>
}