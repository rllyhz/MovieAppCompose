package id.rllyhz.movieappcompose.ui.page

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import id.rllyhz.movieappcompose.MainViewModel
import id.rllyhz.movieappcompose.R
import id.rllyhz.movieappcompose.ui.widget.SimpleAppBar

const val detailPageRoute = "detail_page"

@Composable
fun DetailPage(
    navController: NavController,
    viewModel: MainViewModel,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isMovieFav by remember { mutableStateOf(viewModel.isClickedMovieFav) }

    Column(
        modifier = modifier,
    ) {
        SimpleAppBar(
            title = stringResource(id = R.string.detail_title),
            shouldShowNavigateUp = true,
            onIconBackPressed = {
                navController.navigateUp()
            }
        )

        viewModel.clickedMovie?.let { movie ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = movie.pictureId),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .align(Alignment.Center)
                        .background(Color.Black.copy(alpha = 0.65f))
                )

                Column(
                    modifier = Modifier
                        .padding(top = 126.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                        .background(Color.White)
                        .padding(12.dp)
                ) {
                    Text(
                        text = movie.title,
                        style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold),
                        fontSize = 22.sp,
                        modifier = Modifier
                            .padding(start = 138.dp)
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Row(
                        modifier = Modifier
                            .padding(start = 138.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_duration),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = movie.duration,
                            style = MaterialTheme.typography.body2.copy(
                                fontWeight = FontWeight.Light
                            ),
                            fontSize = 16.sp,
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(start = 138.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_date),
                            contentDescription = "",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = movie.releasedAt,
                            style = MaterialTheme.typography.body2.copy(
                                fontWeight = FontWeight.Light
                            ),
                            fontSize = 16.sp,
                        )
                    }

                    Spacer(modifier = Modifier.size(32.dp))

                    Text(
                        text = "[ " + movie.genres.joinToString { it } + " ]",
                        style = MaterialTheme.typography.body2,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = movie.overview,
                        style = MaterialTheme.typography.body2,
                        fontSize = 18.sp
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = stringResource(id = R.string.director, movie.director),
                        style = MaterialTheme.typography.body2,
                        fontSize = 18.sp
                    )
                }


                Image(
                    painter = painterResource(id = movie.pictureId),
                    contentDescription = movie.title,
                    modifier = Modifier
                        .width(120.dp)
                        .height(190.dp)
                        .offset(28.dp, 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shadow(4.dp),
                    contentScale = ContentScale.FillHeight
                )

                Button(
                    onClick = {
                        if (isMovieFav) {
                            val result = viewModel.deleteFavMovie(movie)

                            if (result > 0) {
                                showToast(
                                    context,
                                    context.getString(R.string.successfully_delete_fav_movies_message)
                                )
                                isMovieFav = false
                            } else {
                                showToast(
                                    context,
                                    context.getString(R.string.failed_to_delete_fav_movies_message)
                                )
                            }
                        } else {
                            val result = viewModel.addToFavMovie(movie)

                            if (result > 0) {
                                showToast(
                                    context,
                                    context.getString(R.string.successfully_add_fav_movies_message)
                                )
                                isMovieFav = true
                            } else {
                                showToast(
                                    context,
                                    context.getString(R.string.failed_to_add_fav_movies_message)
                                )
                            }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(28.dp)
                        .fillMaxWidth()
                ) {
                    Icon(
                        if (isMovieFav) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = stringResource(id = R.string.btn_favorites)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = stringResource(id = if (isMovieFav) R.string.btn_delete_favorites else R.string.btn_add_favorites))
                }
            }
        }
    }
}

private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}