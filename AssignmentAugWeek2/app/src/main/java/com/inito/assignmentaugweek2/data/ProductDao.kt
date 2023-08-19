package com.inito.assignmentaugweek2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Upsert
    suspend fun upsertUser(user: ProductEntity)

    @Upsert
    suspend fun upsertAll(vararg user: ProductEntity)

    @Delete
    suspend fun deleteProduct(user: ProductEntity)

    @Query("SELECT * FROM products ORDER BY product_id")
    fun getByProductId(): Flow<List<ProductEntity>>

    @Query("DELETE FROM products")
    suspend fun deleteAllProducts()
}

