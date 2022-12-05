package com.example.database

import kotlinx.coroutines.flow.Flow

interface StoriesLocalRepositoryContract {
    suspend fun getAllStories(): Flow<List<StoryEntity>>
    suspend fun insertStories(stories: List<StoryEntity>)
}