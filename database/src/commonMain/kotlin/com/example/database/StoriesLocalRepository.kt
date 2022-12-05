package com.example.database

import kotlinx.coroutines.flow.Flow

class StoriesLocalRepository(databaseDriverFactory: DatabaseDriverFactory) :
    StoriesLocalRepositoryContract {
    private val database = Database(databaseDriverFactory)
    override suspend fun getAllStories(): Flow<List<StoryEntity>> {
        return database.getAllStories()
    }

    override suspend fun insertStories(stories: List<StoryEntity>) {
        database.createStories(stories)
    }
}