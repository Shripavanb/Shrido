package `in`.shrido.shrido

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.text.format.DateFormat
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.SimpleTimeZone

class MainActivity : AppCompatActivity() {


    private val gutceurrentDate: String = "12/08/2025"
    private lateinit var listView: ListView
    private lateinit var adapter1: MyCustomAdapter
    private val itemList = mutableListOf<RideData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.main_list)
        //listView = findViewById(R.id.main_list) // Assuming you have a ListView in activity_main.xml

        // Date Format
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())
        System.out.println(" Todays DATE is  "+currentDate)

        //time Format

        // Initialize with some data
        itemList.add(RideData( currentDate,"Hyd", "Armor","5Pm","Kamareddy"))
        itemList.add(RideData("13July25","Nzb", "Hyd","10Am","Siddhipet"))
        itemList.add(RideData(currentDate,"Nirmal", "Hyd","1Pm","Armoor"))
        itemList.add(RideData("14July25","Hyd", "Adilabad","6Pm","Kamareddy"))
        itemList.add(RideData("16July25","NZB", "Adilabad","6Pm","Kamareddy"))
        itemList.add(RideData("16July25","NZB", "Adilabad","6Pm","Kamareddy"))
        itemList.add(RideData("16July25","NZB", "Adilabad","6Pm","Kamareddy"))
        itemList.add(RideData("20July25","JBS", "Adilabad","6Pm","Kamareddy"))


        adapter1 = MyCustomAdapter(this,itemList)
        listView.adapter = adapter1
    }

    fun Onclick_Search(view: View) {
        val source= findViewById<EditText>(R.id.Source)
        val Dest = findViewById<EditText>(R.id.Destination)

        //val myData = RideData.RideDetails( sourcetext.toString(),desttext.toString())
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu)
        return super.onCreateOptionsMenu(menu)
    }

    fun Contact_onClick(view: View) {

    }
}

private fun MenuInflater.inflate(menuRes: Int) {}
