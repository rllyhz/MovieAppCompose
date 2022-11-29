package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import id.rllyhz.movieappcompose.MainViewModel
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.MovieItem
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar
import id.rllyhz.movieappcompose.vo.UIState

const val mainPageRoute = "main_page"

@Composable
fun MainPage(
    viewModel: MainViewModel,
    onItemClickCallback: () -> Unit,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState()

    Column(
        modifier = modifier
    ) {
        SimpleAppBar(
            stringResource(id = R.string.home_title),
            shouldShowNavigateUp = false
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
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
                                        viewModel.clickedMovie = it
                                        onItemClickCallback.invoke()
                                    }
                            )
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}