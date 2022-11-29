package id.rllyhz.movieappcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import id.rllyhz.movieappcompose.data.MovieRepository
import id.rllyhz.movieappcompose.data.model.Movie
import id.rllyhz.movieappcompose.vo.Resource
import id.rllyhz.movieappcompose.vo.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    var restaurants = listOf<Movie>()

    val uiState = MutableStateFlow(UiState.Initial)

    init {
        loadAllRestaurants()
    }

    private fun loadAllRestaurants() {
        viewModelScope.launch {
            repository.getMovies().collectLatest { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        uiState.value = UiState.Loading
                        restaurants = emptyList()
                    }
                    is Resource.Error -> uiState.value = UiState.Error
                    is Resource.Success -> {
                        restaurants = resource.data!!
                        uiState.value = UiState.HasData
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