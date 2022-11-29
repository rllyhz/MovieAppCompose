package id.rllyhz.movieappcompose.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun RestaurantItem(
    pictureUrl: String,
    name: String,
    city: String,
    rating: Float,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = rememberImagePainter(data = pictureUrl),
                contentDescription = name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
            Text(
                text = rating.toString(),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(Color.LightGray)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(16.dp)
            )
        }

        Column {
            Image(
                painter = rememberImagePainter(data = pictureUrl),
                contentDescription = name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(8.dp)
                    .clip(CircleShape)
            )

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = name)
                Text(text = city)
            }
        }
    }
}

@Preview
@Composable
fun RestaurantItemPreview() {
    RestaurantItem(
        "",
        "",
        "",
        4.5f
    )
}