package id.rllyhz.movieappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.rllyhz.movieappcompose.ui.theme.FoodAppComposeTheme
import id.rllyhz.movieappcompose.ui.widget.RestaurantItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    RestaurantList(Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun RestaurantList(
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
            .padding(PaddingValues(16.dp))
    ) {
        items(20) {
            RestaurantItem(
                "",
                "",
                "",
                4.5f,
                modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodAppComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            RestaurantList(Modifier.fillMaxSize())
        }
    }
}