package com.example.models

data class Story(
    var by: String,
    var descendants: Int,
    var id: Int,
    var score: Int,
    var time: Long,
    var title: String,
    var type: String,
    var url: String
)
