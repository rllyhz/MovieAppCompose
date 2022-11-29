package id.rllyhz.movieappcompose.ui.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
    Surface(
        modifier = modifier,
        shape = shape,
        elevation = elevation,
        color = backgroundColor,
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

            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.TopEnd)
                    .clip(shape)
                    .background(Color.White)
                    .padding(vertical = 8.dp, horizontal = 12.dp),
                text = rating.toString(),
                style = MaterialTheme.typography.body2,
                fontSize = 16.sp
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            ) {
                Text(
                    text = genres.joinToString { it },
                    style = MaterialTheme.typography.body2,
                    fontSize = 16.sp,
                )
                Text(
                    text = title, style = MaterialTheme.typography.h1,
                    fontSize = 24.sp,
                )
            }
        }
    }
}

@Preview(widthDp = 520, heightDp = 720)
@Composable
fun MovieItemPreview() {
    MovieItem(
        "Movie title",
        6.4f,
        listOf("Action", "Drama", "Fantasy"),
        id.rllyhz.foodappcompose.R.drawable.ic_launcher_background,
        shape = RoundedCornerShape(8.dp), elevation = 2.dp, backgroundColor = Color.LightGray,
    )
}