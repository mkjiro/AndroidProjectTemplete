package com.example.temp.domain.rxjava

import io.reactivex.rxjava3.core.Single

interface Sample1{
    operator fun invoke() : Single<List<String>>
}

class Sample1Impl():Sample1{
    override fun invoke():Single<List<String>>{
        return Single.just(
            mutableListOf("takahasi","suzuki","yamada")
        )
    }
}