package id.rllyhz.movieappcompose.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleAppBar(
            title = stringResource(id = R.string.about_title),
            shouldShowNavigateUp = true,
            onIconBackPressed = { navController.navigateUp() },
        )

        Card(
            shape = CircleShape,
            elevation = 4.dp,
            modifier = Modifier
                .padding(top = 82.dp, bottom = 32.dp)
                .size(260.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_me), contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Fit
            )
        }

        Text(
            text = stringResource(id = R.string.about_name),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold
            ),
            fontSize = 24.sp
        )

        Text(
            text = stringResource(id = R.string.about_email),
            style = MaterialTheme.typography.body1,
            fontSize = 18.sp
        )
    }
}