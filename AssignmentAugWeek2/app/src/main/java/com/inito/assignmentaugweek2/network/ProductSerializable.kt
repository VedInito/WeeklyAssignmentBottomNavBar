package com.inito.assignmentaugweek2.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductSerializable(
    @SerialName("product_id")
    val productId: String,

    @SerialName("checkout_url")
    val checkoutUrl: String,

    @SerialName("title")
    val title: String,

    @SerialName("price")
    val price: String,

    @SerialName("description")
    val description: String,

    @SerialName("shipping_info")
    val shippingInfo: String,

    @SerialName("discounted_price")
    val discountedPrice: String,

    @SerialName("image_url")
    val imageUrl: String,

    @SerialName("button_text")
    val buttonText: String,

    @SerialName("out_of_stock")
    val outOfStock: Boolean
)

@Serializable
data class Products(
    @SerialName("monitor")
    val monitor: List<ProductSerializable>,

    @SerialName("monitor-pro")
    val monitorPro: List<ProductSerializable>,

    @SerialName("replacement-monitor")
    val replacementMonitor: List<ProductSerializable>,

    @SerialName("transmissive-strip")
    val transmissiveStrip: List<ProductSerializable>,

    @SerialName("reflective-strip")
    val reflectiveStrip: List<ProductSerializable>,

    @SerialName("reflective_3T_strip")
    val reflective3TStrip: List<ProductSerializable>,

    @SerialName("clip")
    val clip: List<ProductSerializable>
)

@Serializable
data class Information(
    @SerialName("shop_message")
    val shopMessage: String
)

@Serializable
data class ProductData(
    @SerialName("products")
    val products: Products,

    @SerialName("information")
    val information: Information
)
