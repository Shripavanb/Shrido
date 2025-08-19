package `in`.shrido.shrido

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Date

class RideDetails : AppCompatActivity() {


    private lateinit var listView: ListView
    private lateinit var adapter1: MyCustomAdapter
    private val itemList = mutableListOf<RideData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ride_details)


        val listView: ListView = findViewById(R.id.selected_rideder_details)
        val receivedIntent: Intent = intent

        // Access extra data from the intent
        val date = receivedIntent.getStringExtra("datedata")
        val source = receivedIntent.getStringExtra("sourcedata")
        val destina = receivedIntent.getStringExtra("destidata")
        val time = receivedIntent.getStringExtra("timedata")
        val via = receivedIntent.getStringExtra("viadata")
        itemList.add(RideData(date.toString(), source.toString(),destina.toString(),time.toString(),via.toString()))

        adapter1 = MyCustomAdapter(this,itemList)
        listView.adapter = adapter1
    }
}