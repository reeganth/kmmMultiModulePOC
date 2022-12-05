package com.example.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


object NetworkStoriesRepository: NetworkStoriesContract {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    override suspend fun getTopStories(): List<NetworkStory> {
        val data: List<Int>
        val items = ArrayList<NetworkStory>()
        try {
            data = httpClient.get("https://hacker-news.firebaseio.com/v0/topstories.json").body()
            println("data length ${data.size}")
            for (i in 0..10){
                val item: NetworkStory = httpClient.get("https://hacker-news.firebaseio.com/v0/item/${data[i]}.json").body()
                items.add(item)
            }
        }catch (e: Exception){
            println("******************* Starting error *******************")
            println(e)
            println("******************* Ending error *******************")
        }
        return items
    }
}