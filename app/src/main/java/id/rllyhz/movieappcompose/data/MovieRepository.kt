package id.rllyhz.movieappcompose.data

import id.rllyhz.movieappcompose.data.model.Movie
import id.rllyhz.movieappcompose.vo.Resource
import kotlinx.coroutines.flow.Flow

abstract class MovieRepository {
    abstract suspend fun getMovies(): Flow<Resource<List<Movie>>>
}