package com.example.intermediatedatalayer

import com.example.data.StoriesRepositoryContract
import com.example.usecases.StoriesDataContract
import kotlinx.coroutines.flow.Flow

class IntermediateStoriesDataSource(private val storiesRepositoryContract: StoriesRepositoryContract): StoriesDataContract  {
    override suspend fun getAllStories(): Flow<List<com.example.models.Story>> {
        return storiesRepositoryContract.getAllStories()
    }
}