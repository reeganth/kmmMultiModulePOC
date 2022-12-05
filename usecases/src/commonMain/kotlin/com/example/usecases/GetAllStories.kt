package com.example.usecases

import com.example.data.StoriesRepositoryContract
import com.example.models.Story
import kotlinx.coroutines.flow.Flow

class GetAllStories (private val storiesRepositoryContract: StoriesRepositoryContract) {
    suspend operator fun invoke(): Flow<List<Story>> {
        return storiesRepositoryContract.getAllStories()
    }
}