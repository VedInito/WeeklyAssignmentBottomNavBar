package com.inito.assignmentaugweek2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ProductEntity::class],
    version = 4
)
abstract class ProductDatabase : RoomDatabase() {
    abstract val dao: ProductDao
}

