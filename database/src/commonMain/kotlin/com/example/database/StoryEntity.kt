package com.example.database

import com.example.models.Story

data class StoryEntity(
    var by: String,
    var descendants: Int,
    var id: Int,
    var score: Int,
    var time: Long,
    var title: String,
    var type: String,
    var url: String
)

fun StoryEntity.asExternalModel() = Story(
    by = by,
    descendants = descendants,
    id = id,
    score = score,
    time = time,
    title = title,
    type = type,
    url = url
)