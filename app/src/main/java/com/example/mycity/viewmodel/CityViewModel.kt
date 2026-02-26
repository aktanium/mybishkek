package com.example.mycity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.mycity.data.DataSource
import com.example.mycity.data.Place

class CityViewModel : ViewModel() {

    val categories = listOf(
        "Restaurants",
        "Parks",
        "Museums",
        "Shopping",
        "Attractions"
    )

    fun getPlacesByCategory(category: String): List<Place> {
        return DataSource.getPlacesByCategory(category)
    }

    fun getPlaceById(id: Int): Place? {
        return DataSource.getPlaceById(id)
    }
}