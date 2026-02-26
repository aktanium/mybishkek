package com.example.mycity.data
import com.example.mycity.R
object DataSource {

    private val places = listOf(

        // Restaurants
        Place(
            id = 1,
            name = "Faiza",
            description = "Popular national cuisine restaurant",
            category = "Restaurants",
            imageRes = R.drawable.faiza
        ),
        Place(
            id = 2,
            name = "Navat",
            description = "Traditional Kyrgyz food",
            category = "Restaurants",
            imageRes = R.drawable.navat
        ),
        Place(
            id = 3,
            name = "Arzu",
            description = "Famous lagman and plov",
            category = "Restaurants",
            imageRes = R.drawable.arzu
        ),

        // Parks
        Place(
            id = 4,
            name = "Oak Park",
            description = "Beautiful park in the city center",
            category = "Parks",
            imageRes = R.drawable.oak_park
        ),
        Place(
            id = 5,
            name = "Victory Park",
            description = "Memorial park with great view",
            category = "Parks",
            imageRes = R.drawable.victory_park
        ),
        Place(
            id = 6,
            name = "Ata-Turk Park",
            description = "Modern park for walking and sports",
            category = "Parks",
            imageRes = R.drawable.ata_turk_park
        ),

        // Museums
        Place(
            id = 7,
            name = "National History Museum",
            description = "Main historical museum of Kyrgyzstan",
            category = "Museums",
            imageRes = R.drawable.history_museum
        ),
        Place(
            id = 8,
            name = "Frunze House Museum",
            description = "Museum of Mikhail Frunze",
            category = "Museums",
            imageRes = R.drawable.frunze_house_museum
        ),
        Place(
            id = 9,
            name = "Fine Arts Museum",
            description = "Art exhibitions and culture",
            category = "Museums",
            imageRes = R.drawable.fine_arts_museum
        ),

        // Shopping
        Place(
            id = 10,
            name = "Dordoi Bazaar",
            description = "Largest market in Central Asia",
            category = "Shopping",
            imageRes = R.drawable.dordoi_bazar
        ),
        Place(
            id = 11,
            name = "Bishkek Park",
            description = "Modern shopping mall",
            category = "Shopping",
            imageRes = R.drawable.bishkek_park
        ),
        Place(
            id = 12,
            name = "Asia Mall",
            description = "Popular mall with cinema",
            category = "Shopping",
            imageRes = R.drawable.asia_mall
        ),

        // Attractions
        Place(
            id = 13,
            name = "Ala-Too Square",
            description = "Main square of Bishkek",
            category = "Attractions",
            imageRes = R.drawable.ala_too
        ),
        Place(
            id = 14,
            name = "Burana Tower",
            description = "Historic minaret near Bishkek",
            category = "Attractions",
            imageRes = R.drawable.burana_tower
        ),
        Place(
            id = 15,
            name = "Panfilov Park",
            description = "Amusement park in the city center",
            category = "Attractions",
            imageRes = R.drawable.panfilov_park
        )
    )

    fun getPlacesByCategory(category: String): List<Place> {
        return places.filter { it.category == category }
    }
    fun getPlaceById(id: Int): Place? {
        return places.find { it.id == id }
    }
}