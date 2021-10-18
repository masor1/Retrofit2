package com.masorone.retrofit2.data.remote.quest

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface QuestApi {

    @GET("./domains/search")
    fun getQuestList(): Single<QuestListResponse>
}