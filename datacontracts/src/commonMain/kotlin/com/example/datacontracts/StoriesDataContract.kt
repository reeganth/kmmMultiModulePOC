package com.example.datacontracts

import com.example.models.Story
import kotlinx.coroutines.flow.Flow

interface StoriesDataContract {
    suspend fun getAllStories(): Flow<List<Story>>
}