package com.example.models

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform