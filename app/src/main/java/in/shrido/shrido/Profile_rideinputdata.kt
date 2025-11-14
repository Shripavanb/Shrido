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
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.FileWriter

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

            val jsonObject = JSONObject()
            val jsonArray = JSONArray()
            val ride_date= view.findViewById<EditText>(R.id.date_List)
            val ride_source = view.findViewById<EditText>(R.id.sour_List)
            val ride_desti = view.findViewById<EditText>(R.id.dest_List)
            val ride_time = view.findViewById<EditText>(R.id.time_List)
            val ride_via=view.findViewById<EditText>(R.id.via_List)

            // Collect data for the first input set
            val ride_date_value = ride_date.text.toString()
            val ride_source_value = ride_source.text.toString()
            val ride_desti_value = ride_desti.text.toString()
            val ride_time_value = ride_time.text.toString()
            val  ride_via_value = ride_via.text.toString()

            // Create a JSONObject for this set
            if (ride_date_value.isNotEmpty() && ride_source_value.isNotEmpty()&&
                ride_desti_value.isNotEmpty()&& ride_time_value.isNotEmpty() &&
                ride_via_value.isNotEmpty()) {

                try {
                    jsonObject.put("date_data", ride_date_value)
                    jsonObject.put("source_data", ride_source_value)
                    jsonObject.put("desti_data", ride_desti_value)
                    jsonObject.put("time_data", ride_time_value)
                    jsonObject.put("via_data", ride_via_value)
                    jsonArray.put(jsonObject)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
//
//            val jsonObject = JSONObject().apply {
//                put("date_data", ride_date_value)
//                put("source_data",ride_source_value )
//                put("desti_data", ride_desti_value)
//                put("time_data", ride_time_value)
//                put("via_data",ride_via_value )
//            }


            Log.d(TAG, "date---Logggg--Data  :${ride_date.text.toString()}")
            Log.d(TAG, "source---Logggg--Data  :${ride_source.text.toString()}")
            Log.d(TAG, "desti---Logggg--Data  :${ride_desti.text.toString()}")
            Log.d(TAG, "via---Logggg--Data  :${ride_via.text.toString()}")

            Log.d(TAG, "jsonObject---Logggg--Data  :${jsonObject}")
            Toast.makeText(context,"jsonObject-----Data  :${jsonObject}", Toast.LENGTH_SHORT).show()
            //--------------------------------------------------------------------

           // Convert JsonObject to String Format
            val userJsonString = jsonObject.toString() // Assuming jsonObject is defined


            // Source - https://stackoverflow.com/a/51788166
// Posted by Alexey Soshin, modified by community. See post 'Timeline' for change history
// Retrieved 2025-11-13, License - CC BY-SA 4.0

            //val listOfStrings = Gson().fromJson(userJsonString, mutableListOf<String>().javaClass)


            val gson = Gson()
            //val myObjectto = gson.toJson(userString, RideData::class.java)
           // val myObjectfrom = gson.fromJson(userJsonString, RideData::class.java)

//            // Define the File Path and its Name
//            val file = File(context?.filesDir, fileName)
//            BufferedWriter(FileWriter(file)).use { bufferedWriter ->
//                bufferedWriter.write(userJsonString)
//                bufferedWriter.close();
//             }
            // Now you can use the jsonArray string (e.g., send it via API)
            Log.d("InputFragment", jsonArray.toString())
             //New Code
            writeJsonToFile(getContext(), fileName, jsonArray.toString())
            //writeJsonArrayToFile(jsonArray,fileName)
        //------------------------------------------------------------------------------------------
        }

        // Inflate the layout for this fragment
        return view
    }

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

    fun writeJsonArrayToFile(jsonArray: JSONArray, filePath: String) {
        try {
            val file = File(filePath)
            FileWriter(file).use { writer ->
                writer.write(jsonArray.toString(2)) // 2 for pretty printing with 2-space indentation
            }
            println("JSONArray successfully written to $filePath")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
//    private fun collectInputsToJsonArray(): JSONArray {
//        val jsonArray = JSONArray()
//
//        // Collect data for the first input set
//        val name1 = nameEditText.text.toString()
//        val amount1 = amountEditText.text.toString()
//
//        // Create a JSONObject for this set
//        if (name1.isNotEmpty() && amount1.isNotEmpty()) {
//            val jsonObject = JSONObject()
//            try {
//                jsonObject.put("name", name1)
//                jsonObject.put("amount", amount1)
//                jsonArray.put(jsonObject)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//
//        // Repeat for other inputs or if you have a dynamic number of inputs (see Method 2)
//
//        return jsonArray
//  }
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