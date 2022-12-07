package com.example.stories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.Story
import com.example.usecases.GetAllStories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class StoriesViewModel(private val getAllStoriesUseCase: GetAllStories) : ViewModel() {
    private val _storiesFlow = Channel<List<Story>>(Channel.BUFFERED)
    val storiesFlow = _storiesFlow.receiveAsFlow()

    fun getAllStories() {
        viewModelScope.launch {
            getAllStoriesUseCase().onEach { result ->
                _storiesFlow.send(result)
            }.launchIn(CoroutineScope(Dispatchers.IO))
        }
    }
}