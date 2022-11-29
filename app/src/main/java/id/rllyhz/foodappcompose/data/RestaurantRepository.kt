package id.rllyhz.foodappcompose.data

import id.rllyhz.foodappcompose.data.model.Restaurant
import id.rllyhz.foodappcompose.vo.Resource
import kotlinx.coroutines.flow.Flow

abstract class RestaurantRepository {
    abstract suspend fun getListRestaurant(): Flow<Resource<List<Restaurant>>>
}