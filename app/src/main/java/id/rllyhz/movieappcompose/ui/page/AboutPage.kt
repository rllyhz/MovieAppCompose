package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar

const val aboutPageRoute = "about_page"

@Composable
fun AboutPage(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SimpleAppBar(
            title = stringResource(id = R.string.about_title),
            shouldShowNavigateUp = true,
            onIconBackPressed = { navController.navigateUp() },
        )
    }
}