package com.inito.assignmentaugweek2.viewmodel

import com.inito.assignmentaugweek2.data.ProductEntity

sealed class ProductDatabaseState {
    data class Success(val productList: List<ProductEntity>) : ProductDatabaseState()
    object Loading : ProductDatabaseState()
    object Error : ProductDatabaseState()
}
