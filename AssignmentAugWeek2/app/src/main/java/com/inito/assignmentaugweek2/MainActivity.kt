package com.inito.assignmentaugweek2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.room.Room
import com.inito.assignmentaugweek2.data.ProductDatabase
import com.inito.assignmentaugweek2.viewmodel.ProductDataViewModel
import com.inito.assignmentaugweek2.viewmodel.ProductDataViewModelFactory

class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            ProductDatabase::class.java, "product"
        ).build()
    }
    private val viewModel: ProductDataViewModel by viewModels {
        ProductDataViewModelFactory(db.dao)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationManager(viewModel)
//            Shop(viewModel)
        }
    }
}