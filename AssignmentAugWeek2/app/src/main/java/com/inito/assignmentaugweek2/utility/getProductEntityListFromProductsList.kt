package com.inito.assignmentaugweek2.utility

import com.inito.assignmentaugweek2.data.ProductEntity
import com.inito.assignmentaugweek2.network.Products

fun getProductEntityListFromProductSerializableList(products: Products): List<ProductEntity> {
    val list = listOf(
        products.monitor,
        products.monitorPro,
        products.reflectiveStrip,
        products.reflective3TStrip,
        products.replacementMonitor,
        products.clip
    )
    val result = mutableListOf<ProductEntity>()
    list.forEach {
        it.forEach { productSerializable ->
            result.add(
                ProductEntity(
                    id = computeHash( productSerializable.productId),
                    productId = productSerializable.productId,
                    checkoutUrl = productSerializable.checkoutUrl,
                    title = productSerializable.title,
                    price = productSerializable.price,
                    shippingInfo = productSerializable.shippingInfo,
                    description = productSerializable.description,
                    discountedPrice = productSerializable.discountedPrice,
                    imageUrl = productSerializable.imageUrl,
                    buttonText = productSerializable.buttonText,
                    outOfStock = productSerializable.outOfStock
                )
            )
        }
    }

    return result
}
