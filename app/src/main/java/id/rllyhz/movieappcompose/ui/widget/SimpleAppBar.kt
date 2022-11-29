package id.rllyhz.movieappcompose.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import id.rllyhz.movieappcompose.R

@Composable
fun SimpleAppBar(
    title: String,
    shouldShowNavigateUp: Boolean,
    elevation: Dp = 4.dp,
    backgroundColor: Color = MaterialTheme.colors.primary,
    onIconBackPressed: (() -> Unit)? = null,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        color = backgroundColor,
        elevation = elevation,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (shouldShowNavigateUp) {
                IconButton(onClick = { onIconBackPressed?.invoke() }) {
                    Icon(Icons.Default.ArrowBack, stringResource(id = R.string.btn_back))
                }

                Spacer(modifier = Modifier.size(16.dp))
            }

            Text(
                text = title,
                style = MaterialTheme.typography.h1,
                fontSize = 20.sp,
            )
        }
    }
}