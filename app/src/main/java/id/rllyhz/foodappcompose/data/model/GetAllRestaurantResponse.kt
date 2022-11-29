package id.rllyhz.foodappcompose.data.model

data class GetAllRestaurantResponse(
    val error: Boolean,
    val message: String,
    val count: Int,
    val restaurants: List<RestaurantResponse>
)

data class RestaurantResponse(
    val id: String,
    val name: String,
    val description: String,
    val pictureId: String,
    val city: String,
    val rating: Float
)