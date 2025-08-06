package `in`.shrido.shrido

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.zip.Inflater
//import kotlinx.androidx.synthetic.main.activity_main.*
//import kotlinx.androidx.synthetic.main.ridedata_info.*

class MainActivity : AppCompatActivity() {

    var listofRides = ArrayList<RideInfo>()
    var adapter:RideInfosAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
       }
        //load rides
        listofRides.add(
            RideInfo("Hyd", "Nizamabad"))
        listofRides.add(
            RideInfo("Hyd", "Mtpl"))
        listofRides.add(
            RideInfo("Hyd", "Vizag"))

        adapter = RideInfosAdapter(this,listofRides)
        findViewById<ListView>(R.id.tvListRiders).adapter = adapter
    }

    fun Onclick_Search(view: View) {
        val source= findViewById<EditText>(R.id.Source)
        val Dest = findViewById<EditText>(R.id.Destination)

        //val myData = RideData.RideDetails( sourcetext.toString(),desttext.toString())
    }


}
class RideInfosAdapter: BaseAdapter{
    var listofRides = ArrayList<RideInfo>()
    var context:Context?=null
    constructor(context:Context,listofRides: ArrayList<RideInfo>):super(){
        this.listofRides=listofRides
    }

    override fun getCount(): Int {
        return  listofRides.size
    }

    override fun getItem(position: Int): Any? {
        return listofRides[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int,convertView: View?,parent: ViewGroup? ): View? {
        //TODO("Not yet implemented")
        val  rideinfo = listofRides[position]
        var inflator =context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var myView = inflator.inflate(R.layout.ridedata_info,null)
        myView.findViewById<TextView>(R.id.sour_List).text=rideinfo.rideFrom!!
       myView.findViewById<TextView>(R.id.dest_List).text = rideinfo.rideTo!!
        return  myView
    }
}

