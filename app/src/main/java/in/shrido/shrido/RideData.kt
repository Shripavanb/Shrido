package `in`.shrido.shrido

import android.R
import kotlinx.serialization.Serializable


data class RideData(
    val date_data: String,
    val source_data: String,
    val desti_data: String,
    val time_data: String,
    val via_data:String,
    var isContactButtonclicked: Boolean =false
)



object JsonConstants {
    const val JSON_FILE_NAME = "user_data.json"
}
