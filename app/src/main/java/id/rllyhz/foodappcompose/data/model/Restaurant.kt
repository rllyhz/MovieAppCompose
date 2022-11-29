package id.rllyhz.foodappcompose.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val smallPictureUrl: String,
    val mediumPictureUrl: String,
    val city: String,
    val rating: Float
) : Parcelable