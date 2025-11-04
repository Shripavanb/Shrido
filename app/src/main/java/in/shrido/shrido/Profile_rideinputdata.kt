package `in`.shrido.shrido

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.io.File
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.FileWriter
import com.google.gson.Gson
import java.io.FileOutputStream


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Profile_rideinputdata.newInstance] factory method to
 * create an instance of this fragment.
 */

@kotlinx.serialization.Serializable
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
            val ride_time = view.findViewById<EditText>(R.id.time_List)
            val ride_via=view.findViewById<EditText>(R.id.via_List)

            val jsonObject = JSONObject().apply {
                put("date_data", ride_date.text.toString())
                put("source_data",ride_source.text.toString() )
                put("desti_data", ride_desti.text.toString())
                put("time_data", ride_time.text.toString())
                put("via_data", ride_via.text.toString())
            }
            Log.d(TAG, "date---Logggg--Data  :${ride_date.text.toString()}")
            Log.d(TAG, "source---Logggg--Data  :${ride_source.text.toString()}")
            Log.d(TAG, "desti---Logggg--Data  :${ride_desti.text.toString()}")
            Log.d(TAG, "via---Logggg--Data  :${ride_via.text.toString()}")

            Log.d(TAG, "jsonObject---Logggg--Data  :${jsonObject}")
            Toast.makeText(context,"jsonObject-----Data  :${jsonObject}", Toast.LENGTH_SHORT).show()

           // Convert JsonObject to String Format
            val userString = jsonObject.toString() // Assuming jsonObject is defined
            // Define the File Path and its Name
            val file = File(context?.filesDir, fileName)
            BufferedWriter(FileWriter(file)).use { bufferedWriter ->
                bufferedWriter.write(userString)
                bufferedWriter.close();
             }
            //file.writeText(userString)

            Log.d(TAG, "via---Logggg--Data  :${file.writeText(userString)}")
            Log.d(TAG, "via---Logggg--Data  :${file.writeText(userString)}")


            //New Code
            var fileName2 = "newdata.json"
            writeJsonToFile(getContext(), fileName2, userString)
            //val jsonString = Json.encodeToString(user)
            //writeJsonToFile(jsonObject, filename2,requireContext())




//------------------------------------------------------------------------------------------
        }

        // Inflate the layout for this fragment
        return view
    }
//Main one
    fun writeJsonToFile(context: Context?, fileName: String, jsonString: String) {
        var fos: FileOutputStream? = null
        try {
            fos = context?.openFileOutput(fileName, Context.MODE_PRIVATE)
            fos?.write(jsonString.toByteArray())
            fos?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fos?.close()
        }
    }
    fun writeJsonToFile(users: JSONObject, fileName: String, context: Context) {

        val gson = Gson()
        val jsonString = gson.toJson(users)

        val file = File(context.filesDir, fileName)
        file.writeText(jsonString)
        Log.d(TAG, "Newwwvia---Logggg--Data  :${file.writeText(jsonString)}")
    }
    // Example usage in an Activity or Fragment:
    // val users = listOf(User(1, "Alice", "alice@example.com"), User(2, "Bob", "bob@example.com"))
    // writeJsonToFile(users, "my_data.json", applicationContext)




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