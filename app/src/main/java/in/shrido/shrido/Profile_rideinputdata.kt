package `in`.shrido.shrido

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.convertTo
import androidx.fragment.app.Fragment
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import org.json.JSONObject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile_rideinputdata.newInstance] factory method to
 * create an instance of this fragment.
 */
class Profile_rideinputdata : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view = inflater.inflate(R.layout.fragment_profile_rideinputdata, container, false)

        val rideinput_submit = view.findViewById<Button>(R.id.ride_input_submit)

        rideinput_submit.setOnClickListener {
            Toast.makeText(context,"RideInput submit utton clicked${rideinput_submit} ", Toast.LENGTH_SHORT).show()
  //--------------------------------------------------------------------

            val ride_date= view.findViewById<EditText>(R.id.date_List)
            val ride_source = view.findViewById<EditText>(R.id.sour_List)
            val ride_desti = view.findViewById<EditText>(R.id.dest_List)
            val ride_via=view.findViewById<EditText>(R.id.via_List)

            val jsonObject = JSONObject().apply {
                put("Date", ride_date.text.toString())
                put("Source",ride_source.text.toString() )
                put("Destination", ride_desti.text.toString())
                put("via", ride_via.text.toString())
//                put("Time", view.findViewById<EditText>(R.id.tim))
            }
            Log.d(TAG, "date---Logggg--Data  :${ride_date.text.toString()}")
            Log.d(TAG, "source---Logggg--Data  :${ride_source.text.toString()}")
            Log.d(TAG, "desti---Logggg--Data  :${ride_desti.text.toString()}")
            Log.d(TAG, "via---Logggg--Data  :${ride_via.text.toString()}")

            Log.d(TAG, "jsonObject---Logggg--Data  :${jsonObject}")
            Toast.makeText(context,"jsonObject-----Data  :${jsonObject}", Toast.LENGTH_SHORT).show()

//            val filename = "userdata.json"
//            val file = File(requireContext().getFilesDir(), filename)
//            val fileReader = FileReader(file)
//            val bufferedReader = BufferedReader(fileReader)
//            val stringBuilder = StringBuilder()
//            var line = bufferedReader.readLine()
//            while (line != null) {
//                stringBuilder.append(line).append("\n")
//                line = bufferedReader.readLine()
//            }
//            bufferedReader.close()
//
//
//
//            // This responce will have Json Format String
//            val responce = stringBuilder.toString()
//        Toast.makeText(context,"RideInput submit utton clicked :${responce}", Toast.LENGTH_SHORT).show()
       // submit input data toJSon file
//------------------------------------------------------------------------------------------
        }

        // Inflate the layout for this fragment
        return view
    }


//
//    private fun writeJSONtoFile(s:String) {
//        //Create list to store the all Tags
//        var tags = ArrayList<String>()
//        // Add the Tag to List
//        tags.add("Android")
//        tags.add("Angular")
//        //Create a Object of Post
//        var post = Post("Json Tutorial", "www.nplix.com", "Pawan Kumar", tags)
//        //Create a Object of Gson
//        var gson = Gson()
//        //Convert the Json object to JsonString
//        var jsonString:String = gson.toJson(post)
//        //Initialize the File Writer and write into file
//        val file=File(s)
//        file.writeText(jsonString)
//    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Profile_rideinputdata.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Profile_rideinputdata().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}