package com.example.usecases

import com.example.datacontracts.StoriesDataContract
import com.example.models.Story
import kotlinx.coroutines.flow.Flow

class GetAllStories (private val storiesDataContract: StoriesDataContract) {
    suspend operator fun invoke(): Flow<List<Story>> {
        return storiesDataContract.getAllStories()
    }
}