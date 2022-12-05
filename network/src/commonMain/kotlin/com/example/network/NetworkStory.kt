package com.example.network

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class NetworkStory(
    @SerialName("by")
    var by: String,
    @SerialName("descendants")
    var descendants: Int,
    @SerialName("id")
    var id: Int,
    @SerialName("kids")
    var kids: ArrayList<Int>? = null,
    @SerialName("score")
    var score: Int,
    @SerialName("time")
    var time: Long,
    @SerialName("title")
    var title: String,
    @SerialName("type")
    var type: String,
    @SerialName("url")
    var url: String
)
