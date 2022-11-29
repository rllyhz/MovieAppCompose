package id.rllyhz.foodappcompose.utils

import id.rllyhz.foodappcompose.data.model.Restaurant
import id.rllyhz.foodappcompose.data.model.RestaurantResponse

fun List<RestaurantResponse>.toEntities(): List<Restaurant> {
    val allRestaurant = arrayListOf<Restaurant>()

    for (item in this) {
        val restaurant = Restaurant(
            id = item.id,
            name = item.name,
            description = item.description,
            smallPictureUrl = smallPictureSizeBaseUrl + item.pictureId,
            mediumPictureUrl = mediumPictureSizeBaseUrl + item.pictureId,
            city = item.city,
            rating = item.rating
        )

        allRestaurant.add(restaurant)
    }

    return allRestaurant
}