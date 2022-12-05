package com.example.data.model

import com.example.database.StoryEntity
import com.example.network.NetworkStory

fun NetworkStory.asEntity() = StoryEntity(
    by = by,
    descendants = descendants,
    id = id,
    score = score,
    time = time,
    title = title,
    type = type,
    url = url
)