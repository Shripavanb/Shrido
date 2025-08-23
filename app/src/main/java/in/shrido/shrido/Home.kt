package `in`.shrido.shrido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Date


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val gutceurrentDate: String = "12/08/2025"
    private lateinit var listView: ListView
    private lateinit var adapter1: MyCustomAdapter
    private val itemList = mutableListOf<RideData>()
    private val itemList2 = mutableListOf<RideData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

         listView = view.findViewById<ListView>(R.id.main_list) // Assuming you have a ListView in activity_main.xml

        // Date Format
//            val sdf = SimpleDateFormat("dd/M/yyyy")
//            val currentDate = sdf.format(Date())
//            System.out.println(" Todays DATE is  "+currentDate)

        val jsonString: String
        // Open the asset file as an InputStream
        val inputStream = requireContext().assets.open("rideinputdata.json")
        // Get the size of the file
        val size = inputStream.available()
        // Create a byte array to hold the data
        val buffer = ByteArray(size)
        // Read the data into the buffer
        inputStream.read(buffer)
        // Close the input stream
        inputStream.close()
        // Convert the byte array to a String
        jsonString = String(buffer, Charsets.UTF_8)

        val gson = Gson()
        val listType = object : TypeToken<List<RideData>>() {}.type
        val itemList2: List<RideData> = gson.fromJson(jsonString, listType)

        val adapter1 = MyCustomAdapter(requireContext(), itemList2 as MutableList<RideData>)
        listView.setAdapter(adapter1)

        listView.adapter = adapter1


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}