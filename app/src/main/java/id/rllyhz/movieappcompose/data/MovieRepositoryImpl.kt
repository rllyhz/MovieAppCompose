package id.rllyhz.movieappcompose.data

import id.rllyhz.movieappcompose.data.model.Movie
import id.rllyhz.movieappcompose.vo.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class MovieRepositoryImpl : MovieRepository() {

    override suspend fun getMovies(): Flow<Resource<List<Movie>>> =
        flow {
            emit(Resource.Loading())

            try {
                delay(2000)

                val movies = getAllMovies()
                emit(Resource.Success(movies))

            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
                e.printStackTrace()
            }
        }

    override fun searchMovies(query: String): List<Movie> {
        val movies = getAllMovies()

        return movies.filter {
            it.title.lowercase(Locale.getDefault())
                .contains(query.lowercase(Locale.getDefault()))
        }
    }

    override fun getFavMovies(): Flow<Resource<List<Movie>>> =
        flow {
            emit(Resource.Loading())

            try {
                delay(250)

                val movies = getAllFavMovies()
                emit(Resource.Success(movies))

            } catch (e: Exception) {
                emit(Resource.Error(e.message.toString()))
                e.printStackTrace()
            }
        }

    override fun addToFavMovies(movie: Movie): Int =
        addFavMovie(movie)

    override fun isMovieFav(movie: Movie): Boolean =
        getAllFavMovies().contains(movie)

    override fun deleteFromFavMovies(movie: Movie): Int =
        deleteFavMovie(movie)

    override fun deleteAllFavMovies(): Boolean =
        deleteAll()

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