package com.example.data

import com.example.models.Story
import kotlinx.coroutines.flow.Flow

interface StoriesRepositoryContract {
    suspend fun getAllStories(): Flow<List<Story>>
}