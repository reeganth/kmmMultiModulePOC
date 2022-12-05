package com.example.database

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQueries = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQueries.transaction {
            dbQueries.removeAllStories()
        }
    }

    internal fun getAllStories(): Flow<List<StoryEntity>> {
        return dbQueries.selectAllStories(::mapStoriesSelecting).asFlow().mapToList()
    }

    internal fun createStories(storyEntities: List<StoryEntity>) {
        dbQueries.transaction {
            storyEntities.forEach { storyEntity ->
//                val story = dbQueries.selectStoryById(storyEntity.id).executeAsOneOrNull()
//                if (story == null) {
//                    insertStory(storyEntity)
//                }
                insertStory(storyEntity)
            }
        }
    }

    private fun insertStory(storyEntity: StoryEntity) {
        dbQueries.insertStories(
            storyEntity.by,
            storyEntity.descendants.toLong(),
            storyEntity.id.toLong(),
            storyEntity.score.toLong(),
            storyEntity.time,
            storyEntity.title,
            storyEntity.type,
            storyEntity.url
        )
    }

    private fun mapStoriesSelecting(
        by: String,
        descendants: Long,
        id: Long,
        score: Long,
        time: Long,
        title: String,
        type: String,
        url: String
    ): StoryEntity {
        return StoryEntity(
            by,
            descendants.toInt(),
            id.toInt(),
            score.toInt(),
            time,
            title,
            type,
            url
        )
    }
}