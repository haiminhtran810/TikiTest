package com.hai.data.usecase

import com.hai.data.repository.TikiRepository
import io.reactivex.Single

class GetKeyWordUseCase(private val tikiRepository: TikiRepository) : UseCase<Void, Single<List<String>>>() {
    override fun createObservable(params: Void?): Single<List<String>> {
        return tikiRepository.getKeyWord()
    }

    override fun onCleared() {
    }
}