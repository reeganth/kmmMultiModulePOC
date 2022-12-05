package com.example.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class Greeting {
    private val platform: Platform = getPlatform()

    fun greeting(): String {
        CoroutineScope(Dispatchers.Default).launch {
            NetworkStoriesRepository.getTopStories().forEach {
                println("reeganth: news: $it")
            }
        }
        return "Hello, ${platform.name}!"
    }

    fun getTopStories(){
        CoroutineScope(Dispatchers.Default).launch {

        }
    }
}