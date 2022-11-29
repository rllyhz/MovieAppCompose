package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.rllyhz.movieappcompose.MainViewModel
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.MovieItem
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar
import id.rllyhz.movieappcompose.vo.UIState

const val favMoviesPageRoute = "fav_movies_page"

@Composable
fun FavMoviesPage(
    navController: NavController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.favMoviesUiState.collectAsState()
    val favMovies by remember { viewModel.favMovies }

    LaunchedEffect(true) {
        viewModel.loadAllFavMovies()
    }

    Column(
        modifier = modifier,
    ) {
        SimpleAppBar(
            title = stringResource(id = R.string.fav_movies_title),
            shouldShowNavigateUp = true,
            onIconBackPressed = {
                navController.navigateUp()
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            when (uiState.value) {
                UIState.Error -> {
                    Text(
                        text = stringResource(id = R.string.empty_fav_movies_message),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                UIState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                UIState.HasData -> {
                    if (favMovies.isEmpty()) {
                        Text(
                            text = stringResource(id = R.string.empty_fav_movies_message),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    } else {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center),
                            contentPadding = PaddingValues(top = 16.dp)
                        ) {
                            items(favMovies) {
                                MovieItem(
                                    title = it.title,
                                    rating = it.rating,
                                    genres = it.genres,
                                    pictureId = it.pictureId,
                                    shape = RoundedCornerShape(8.dp),
                                    elevation = 3.dp,
                                    backgroundColor = Color.LightGray,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(620.dp)
                                        .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                                        .clickable {
                                            viewModel.clickedMovie = it
                                            navController.navigate(detailPageRoute)
                                        }
                                )
                            }
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}