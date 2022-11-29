package id.rllyhz.foodappcompose.data

import id.rllyhz.foodappcompose.data.api.RestaurantApi
import id.rllyhz.foodappcompose.data.model.Restaurant
import id.rllyhz.foodappcompose.utils.toEntities
import id.rllyhz.foodappcompose.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class RestaurantRepositoryImpl(
    private val api: RestaurantApi
) : RestaurantRepository() {

    override suspend fun getListRestaurant(): Flow<Resource<List<Restaurant>>> =
        flow {
            emit(Resource.Loading())

            try {
                val responseData = api.getAllRestaurant()

                if (responseData.error) {
                    emit(Resource.Error(responseData.message))
                } else if (responseData.count <= 0) {
                    emit(Resource.Success(emptyList()))
                } else {
                    val allRestaurant = responseData.restaurants.toEntities()
                    emit(Resource.Success(allRestaurant))
                }

            } catch (e: HttpException) {
                emit(Resource.Error(e.message()))
                e.printStackTrace()
            } catch (e: IOException) {
                emit(Resource.Error(e.message.toString()))
                e.printStackTrace()
            }
        }
}