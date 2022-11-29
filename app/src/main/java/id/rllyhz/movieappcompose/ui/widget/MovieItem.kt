package id.rllyhz.movieappcompose.ui.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieItem(
    title: String,
    rating: Float,
    genres: List<String>,
    @DrawableRes pictureId: Int,
    shape: Shape,
    elevation: Dp,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        backgroundColor = backgroundColor,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = pictureId),
                contentDescription = title,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black),
                        )
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = genres.joinToString { it },
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    color = Color.White
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.h1.copy(fontWeight = FontWeight.SemiBold),
                    fontSize = 26.sp,
                    color = Color.White
                )
            }

            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd),
                elevation = 3.dp,
                shape = shape,
                color = MaterialTheme.colors.primary
            ) {
                Text(
                    text = rating.toString(),
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 12.dp)
                )
            }
        }
    }
}

@Preview(widthDp = 480, heightDp = 760)
@Composable
fun MovieItemPreview() {
    MovieItem(
        "Movie title",
        6.4f,
        listOf("Action", "Drama", "Fantasy"),
        id.rllyhz.movieappcompose.R.drawable.movie_1,
        shape = RoundedCornerShape(8.dp), elevation = 2.dp, backgroundColor = Color.LightGray,
    )
}