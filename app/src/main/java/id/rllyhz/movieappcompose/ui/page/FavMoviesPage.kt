package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import id.rllyhz.movieappcompose.MainViewModel
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar

const val favMoviesPageRoute = "fav_movies_page"

@Composable
fun FavMoviesPage(
    navController: NavController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
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
    }
}