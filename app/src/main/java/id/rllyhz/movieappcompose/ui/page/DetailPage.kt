package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import id.rllyhz.movieappcompose.MainViewModel
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar

const val detailPageRoute = "detail_page"

@Composable
fun DetailPage(
    viewModel: MainViewModel,
    onNavigateUpCallback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SimpleAppBar(
            title = stringResource(id = R.string.detail_title),
            shouldShowNavigateUp = true,
            onIconBackPressed = {
                onNavigateUpCallback.invoke()
            }
        )
    }
}