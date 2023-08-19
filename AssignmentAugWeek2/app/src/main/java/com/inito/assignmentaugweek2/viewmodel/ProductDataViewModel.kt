package com.inito.assignmentaugweek2.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.inito.assignmentaugweek2.data.ProductDao
import com.inito.assignmentaugweek2.network.ProductApi
import com.inito.assignmentaugweek2.utility.getProductEntityListFromProductSerializableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProductDataViewModelFactory(
    private val dao: ProductDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductDataViewModel(dao) as T
    }
}

class ProductDataViewModel(
    private val dao: ProductDao
) : ViewModel() {
    private var _productNetworkState: MutableStateFlow<ProductNetworkState> =
        MutableStateFlow(ProductNetworkState.Loading)

    private var _productDatabaseState = dao.getByProductId()
    val productDatabaseState = _productDatabaseState.stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(), emptyList()
    )

    init {
        updateProductNetworkState()
        updateProductDebaseState()
    }

    private fun updateProductNetworkState() {
        viewModelScope.launch {
//            delay(1000)
            try {
                val networkResponse = ProductApi.retrofitService.getProductData()
                _productNetworkState.value =
                    ProductNetworkState.Success(productData = networkResponse)
                dao.deleteAllProducts()
            } catch (_: Exception) {
            }
        }
    }

    private fun updateProductDebaseState() {
        viewModelScope.launch {
//            delay(5000)

            _productNetworkState.collect { productState ->
                if (productState is ProductNetworkState.Success) {
                    val productEntityList =
                        getProductEntityListFromProductSerializableList(productState.productData.products)
                    productEntityList.forEach { productEntity ->
                        dao.upsertUser(productEntity)
                    }
                }
            }
        }
    }
}
