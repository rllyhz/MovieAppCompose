package id.rllyhz.movieappcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import id.rllyhz.movieappcompose.data.MovieRepository
import id.rllyhz.movieappcompose.data.model.Movie
import id.rllyhz.movieappcompose.vo.Resource
import id.rllyhz.movieappcompose.vo.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    var movies = listOf<Movie>()
    var favMovies = listOf<Movie>()
    val homeUiState = MutableStateFlow(UIState.Initial)
    val favMoviesUiState = MutableStateFlow(UIState.Initial)

    var clickedMovie: Movie? = null

    fun loadAllMovies() {
        if (movies.isNotEmpty()) return

        viewModelScope.launch {
            homeUiState.value = UIState.Initial

            repository.getMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        homeUiState.value = UIState.Loading
                        movies = emptyList()
                    }
                    is Resource.Error -> homeUiState.value = UIState.Error
                    is Resource.Success -> {
                        movies = resource.data!!
                        homeUiState.value = UIState.HasData
                    }
                }
            }
        }
    }

    fun loadAllFavMovies() {
        viewModelScope.launch {
            favMoviesUiState.value = UIState.Initial

            repository.getFavMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        favMoviesUiState.value = UIState.Loading
                        favMovies = emptyList()
                    }
                    is Resource.Error -> favMoviesUiState.value = UIState.Error
                    is Resource.Success -> {
                        favMovies = resource.data!!
                        favMoviesUiState.value = UIState.HasData
                    }
                }
            }
        }
    }

    fun addToFavMovie(movie: Movie) {
        repository.addToFavMovies(movie)
    }

    fun deleteFavMovie(movie: Movie) {
        repository.deleteFromFavMovies(movie)
    }


    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val repository: MovieRepository
    ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            MainViewModel(repository) as T
    }
}