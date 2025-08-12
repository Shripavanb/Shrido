package `in`.shrido.shrido

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    private lateinit var listView: ListView
    private lateinit var adapter1: MyCustomAdapter
    private val itemList = mutableListOf<RideData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val listView: ListView = findViewById(R.id.main_list)
        //listView = findViewById(R.id.main_list) // Assuming you have a ListView in activity_main.xml

//        val listItems = arrayListOf("Hyderabad",
//            "Armoor",
//            "Nizamabad",
//            "Kamareddy")
//
//        val listAdapter= ArrayAdapter(this, android.R.layout.list_content,listItems)
//        listView.adapter = listAdapter

        // Initialize with some data
        itemList.add(RideData("Hyd", "Armor"))
        itemList.add(RideData("Nzb", "Hyd"))
        itemList.add(RideData("Nirmal", "Hyd"))
        itemList.add(RideData("Hyd", "Adilabad"))

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
}

private fun MenuInflater.inflate(menuRes: Int) {}
