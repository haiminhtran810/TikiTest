package com.hai.data.repository

import io.reactivex.Single

interface TikiRepository {
    fun getKeyWord(): Single<List<String>>
}