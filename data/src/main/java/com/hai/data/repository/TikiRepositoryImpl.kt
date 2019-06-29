package com.hai.data.repository

import com.hai.data.repository.remote.TikiApi
import io.reactivex.Single

class TikiRepositoryImpl(private val tikiApi: TikiApi) : TikiRepository {
    override fun getKeyWord(): Single<List<String>> {
        return tikiApi.getKeyWord()
    }
}
