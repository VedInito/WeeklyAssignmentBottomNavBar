package com.inito.assignmentaugweek2.viewmodel

import com.inito.assignmentaugweek2.network.ProductData

sealed class ProductNetworkState {
    data class Success(val productData: ProductData) : ProductNetworkState()
    object Loading : ProductNetworkState()
    object Error : ProductNetworkState()
}
