package com.masorone.retrofit2.data.remote.quest

import com.google.gson.annotations.SerializedName

data class QuestListResponse(val domains: List<QuestListItem>)

data class QuestListItem(
    @SerializedName("domain")
    val domain: String,

    @SerializedName("create_date")
    val create_date: String,

    @SerializedName("update_date")
    val update_date: String
)