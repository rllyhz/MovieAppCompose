package id.rllyhz.movieappcompose.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val duration: String,
    val releasedAt: String,
    val overview: String,
    val director: String,
    val rating: Float,
    @DrawableRes val pictureId: Int
) : Parcelable