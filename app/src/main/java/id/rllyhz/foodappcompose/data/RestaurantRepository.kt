package id.rllyhz.foodappcompose.data

abstract class RestaurantRepository {
    abstract suspend fun getAllMenus()
    abstract suspend fun getMenuDetailOf(id: String)
}