package id.rllyhz.movieappcompose.data.model

import android.os.Parcelable
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
) : Parcelable