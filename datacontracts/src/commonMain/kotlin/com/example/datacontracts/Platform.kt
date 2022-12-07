package com.example.datacontracts

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform