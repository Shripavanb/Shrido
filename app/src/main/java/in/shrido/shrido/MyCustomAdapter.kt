package `in`.shrido.shrido

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class MyCustomAdapter (private val context: Context,private val dataList: MutableList<RideData>): BaseAdapter(){

    override fun getCount(): Int = dataList.size

    override fun getItem(position:Int): Any= dataList[position]
    override fun getItemId(position: Int): Long = position.toLong()


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View
        val holder: ViewHolder
        
        if(convertView==null){
            view = LayoutInflater.from(context).inflate(R.layout.rideinfo_list,parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
        view = convertView
            holder= view.tag as ViewHolder
        }
        val item = dataList[position]
        holder.datetextView.text = item.date_data
        holder.sourceTextView.text=item.source_data
        holder.destinationTextView.text=item.desti_data
        holder.timeTextView.text=item.time_data
        holder.viaTextView.text = item.via_data
        

        val contactButton = view.findViewById<Button>(R.id.contact_List)
        contactButton.visibility = if(item.isContactButtonclicked) View.GONE else View.VISIBLE
        // Set OnClickListener for the button
        contactButton.setOnClickListener {
            // Handle button click here
            // You can access 'currentItem' and 'position' for specific item data
            Toast.makeText(context, "Button clicked for item: ${item.source_data}", Toast.LENGTH_SHORT).show()
            // Perform other actions like navigating to a new activity, updating data, etc.
            item.isContactButtonclicked = true
            notifyDataSetChanged()
            // Create an Intent to navigate to the new screen
            val intent = Intent(context, RideDetails::class.java)
            // Pass data to the new screen (e.g., item ID)
            intent.putExtra("datedata", item.date_data)
            intent.putExtra("sourcedata", item.source_data)
            intent.putExtra("destidata",item.desti_data)
            intent.putExtra("timedata",item.time_data)
            intent.putExtra("viadata",item.via_data)
            intent.putExtra("isContactButtonclicked",true)
            context.startActivity(intent)
        }
        

        return view
    }
    private class ViewHolder(view: View) {
        val datetextView: TextView = view.findViewById(R.id.date_List)
        val sourceTextView: TextView = view.findViewById(R.id.sour_List)
        val destinationTextView: TextView = view.findViewById(R.id.dest_List)
        val timeTextView: TextView = view.findViewById(R.id.Time_List)
        val viaTextView: TextView = view.findViewById(R.id.via_List)
        // val itemImageView: ImageView = view.findViewById(R.id.itemImageView)
    }


    fun additem(item: RideData)
    {
        dataList.add(item)
        notifyDataSetChanged()// Notify the ListView that the data has changed
    }

    fun addAllItems(items: List<RideData>){
        dataList.addAll(items)
        notifyDataSetChanged()
    }

}