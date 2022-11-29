package id.rllyhz.movieappcompose.data

import id.rllyhz.movieappcompose.data.model.Movie
import id.rllyhz.movieappcompose.vo.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl : MovieRepository() {

    override suspend fun getMovies(): Flow<Resource<List<Movie>>> =
        flow {
            emit(Resource.Loading())

            try {
                delay(2000)

                emit(Resource.Success(getAllMovies()))

            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
                e.printStackTrace()
            }
        }


    companion object {
        private var instance: MovieRepository? = null

        fun getInstance(): MovieRepository {
            if (instance == null) {
                instance = MovieRepositoryImpl()
            }

            return instance!!
        }
    }
}