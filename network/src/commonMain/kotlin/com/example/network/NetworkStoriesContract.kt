package com.example.network

interface NetworkStoriesContract {
    suspend fun getTopStories(): List<NetworkStory>
}