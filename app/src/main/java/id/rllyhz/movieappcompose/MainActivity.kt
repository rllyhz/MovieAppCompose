package id.rllyhz.movieappcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import id.rllyhz.movieappcompose.data.MovieRepositoryImpl
import id.rllyhz.movieappcompose.ui.theme.FoodAppComposeTheme
import id.rllyhz.movieappcompose.ui.widget.MovieItem
import id.rllyhz.movieappcompose.vo.UIState

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = MovieRepositoryImpl.getInstance()
        viewModel = MainViewModel.Factory(repository).create(MainViewModel::class.java)

        setContent {
            FoodAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MovieList(viewModel, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun MovieList(
    viewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState = viewModel.uiState.collectAsState()
    val context = LocalContext.current

    Box(
        modifier = modifier
    ) {
        when (uiState.value) {
            UIState.Error -> {
                Text(
                    text = "Belum ada data!",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            UIState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            UIState.HasData -> {
                val movies = viewModel.movies

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    contentPadding = PaddingValues(top = 16.dp)
                ) {
                    items(movies) {
                        MovieItem(
                            it.title,
                            it.rating,
                            it.genres,
                            it.pictureId,
                            RoundedCornerShape(8.dp),
                            2.dp,
                            Color.LightGray,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(620.dp)
                                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                                .clickable {
                                    Toast
                                        .makeText(
                                            context,
                                            "Clicked ${it.id}",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                        )
                    }
                }
            }
            else -> Unit
        }
    }
}