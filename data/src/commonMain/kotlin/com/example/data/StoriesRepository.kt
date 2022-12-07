package com.example.data

import com.example.data.model.asEntity
import com.example.database.StoriesLocalRepositoryContract
import com.example.database.StoryEntity
import com.example.database.asExternalModel
import com.example.datacontracts.StoriesDataContract
import com.example.models.Story
import com.example.network.NetworkStoriesContract
import com.example.network.NetworkStory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoriesRepository(
    private val networkStoriesRepository: NetworkStoriesContract,
    private val storiesLocalRepositoryContract: StoriesLocalRepositoryContract
) : StoriesDataContract {

    override suspend fun getAllStories(): Flow<List<Story>> {
        val networkStories = networkStoriesRepository.getTopStories()
        val storyEntities = networkStories.map(NetworkStory::asEntity)
        storiesLocalRepositoryContract.insertStories(storyEntities)
        return storiesLocalRepositoryContract.getAllStories()
            .map { it.map(StoryEntity::asExternalModel) }
    }
}