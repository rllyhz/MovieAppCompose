package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import id.rllyhz.movieappcompose.MainViewModel
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.MovieItem
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar
import id.rllyhz.movieappcompose.vo.UIState

const val homePageRoute = "home_page"

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomePage(
    navController: NavController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val uiState = viewModel.homeUiState.collectAsState()
    val movies by remember { viewModel.movies }
    var searchQuery by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        viewModel.loadAllMovies()
    }

    Column(
        modifier = modifier
    ) {
        SimpleAppBar(
            stringResource(id = R.string.home_title),
            shouldShowNavigateUp = false,
            actions = {
                IconButton(onClick = { navController.navigate(favMoviesPageRoute) }) {
                    Icon(Icons.Default.Favorite, contentDescription = favMoviesPageRoute)
                }

                IconButton(onClick = { navController.navigate(aboutPageRoute) }) {
                    Icon(Icons.Default.Person, contentDescription = aboutPageRoute)
                }
            }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                singleLine = true,
                placeholder = { Text(text = stringResource(id = R.string.btn_search_movies)) },
                keyboardActions = KeyboardActions(
                    onSearch = {
                        keyboardController?.hide()
                        viewModel.searchMovies(searchQuery)
                    }
                ),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                when (uiState.value) {
                    UIState.Error -> {
                        Text(
                            text = stringResource(id = R.string.empty_movies_message),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    UIState.Loading -> {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                    UIState.HasData -> {
                        if (movies.isEmpty()) {
                            Text(
                                text = stringResource(id = R.string.not_found_movies_message),
                                modifier = Modifier.align(Alignment.Center)
                            )
                        } else {
                            LazyColumn(
                                modifier = Modifier.fillMaxWidth(),
                                contentPadding = PaddingValues(top = 16.dp)
                            ) {
                                items(movies) {
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
}