package id.rllyhz.movieappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.rllyhz.movieappcompose.data.MovieRepositoryImpl
import id.rllyhz.movieappcompose.ui.page.DetailPage
import id.rllyhz.movieappcompose.ui.page.MainPage
import id.rllyhz.movieappcompose.ui.page.detailPageRoute
import id.rllyhz.movieappcompose.ui.page.mainPageRoute
import id.rllyhz.movieappcompose.ui.theme.FoodAppComposeTheme

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = MovieRepositoryImpl.getInstance()
        viewModel = MainViewModel.Factory(repository).create(MainViewModel::class.java)

        setContent {
            FoodAppComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = mainPageRoute) {
                        composable(mainPageRoute) {
                            MainPage(
                                viewModel = viewModel,
                                onItemClickCallback = {
                                    navController.navigate(detailPageRoute)
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            )
                        }

                        composable(detailPageRoute) {
                            DetailPage(
                                viewModel = viewModel,
                                onNavigateUpCallback = {
                                    navController.navigateUp()
                                },
                                Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            )
                        }
                    }
                }
            }
        }
    }
}