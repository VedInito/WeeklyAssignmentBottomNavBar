package com.inito.assignmentaugweek2.screen.shop

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.inito.assignmentaugweek2.viewmodel.ProductDataViewModel

@Composable
fun Shop(
    productDataViewModel: ProductDataViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val productEntityListState = productDataViewModel.productDatabaseState
        val productEntityList = productEntityListState.collectAsState(initial = emptyList()).value

        if (productEntityList.isEmpty())
            Loading(message = "Fetching Data")
        else
            Success(products = productEntityList)
    }
}