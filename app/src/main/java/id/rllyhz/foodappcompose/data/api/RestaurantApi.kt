package id.rllyhz.foodappcompose.data.api

import id.rllyhz.foodappcompose.data.model.GetAllRestaurantResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RestaurantApi {

    @GET("/list")
    suspend fun getAllRestaurant(): GetAllRestaurantResponse

    companion object {
        private var apiService: RestaurantApi? = null

        fun getInstance(): RestaurantApi {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()
                    .create(RestaurantApi::class.java)
            }

            return apiService!!
        }
    }
}