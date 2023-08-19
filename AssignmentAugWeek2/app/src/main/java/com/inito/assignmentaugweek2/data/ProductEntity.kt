package com.inito.assignmentaugweek2.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Long = 0,

    @ColumnInfo(name = "product_id")
    val productId: String,

    @ColumnInfo(name = "checkout_url")
    val checkoutUrl: String,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "price")
    val price: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "shipping_info")
    val shippingInfo: String,

    @ColumnInfo(name = "discounted_price")
    val discountedPrice: String,

    @ColumnInfo(name = "image_url")
    val imageUrl: String,

    @ColumnInfo(name = "button_text")
    val buttonText: String,

    @ColumnInfo(name = "out_of_stock")
    val outOfStock: Boolean
)
