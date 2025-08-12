package `in`.shrido.shrido

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
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
        //holder.datetextView.text = item.date_data
        holder.sourceTextView.text=item.source_data
        holder.destinationTextView.text=item.desti_data
        

        return view
    }
    private class ViewHolder(view: View) {
        //val datetextView: TextView = view.findViewById(R.id.date_List)
        val sourceTextView: TextView = view.findViewById(R.id.sour_List)
        val destinationTextView: TextView = view.findViewById(R.id.dest_List)
        //val timeTextView: TextView = view.findViewById(R.id.Time_List)
        //val viaTextView: TextView = view.findViewById(R.id.via_List)
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