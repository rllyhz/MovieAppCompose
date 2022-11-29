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
    val uiState = MutableStateFlow(UIState.Initial)

    var clickedMovie: Movie? = null

    init {
        loadAllRestaurants()
    }

    private fun loadAllRestaurants() {
        viewModelScope.launch {
            repository.getMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        uiState.value = UIState.Loading
                        movies = emptyList()
                    }
                    is Resource.Error -> uiState.value = UIState.Error
                    is Resource.Success -> {
                        movies = resource.data!!
                        uiState.value = UIState.HasData
                    }
                }
            }
        }
    }


    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val repository: MovieRepository
    ) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            MainViewModel(repository) as T
    }
}