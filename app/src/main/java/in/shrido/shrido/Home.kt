package `in`.shrido.shrido

import android.content.Context
import android.os.Bundle
import android.util.Log

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.FileOutputStream
import java.io.InputStreamReader
import java.io.File



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
val fileName = JsonConstants.JSON_FILE_NAME
var count =0

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



//    private lateinit var jsonFileHandler: JsonFileHandler


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

        listView =
            view.findViewById<ListView>(R.id.main_list) // Assuming you have a ListView in activity_main.xml

        // Date Format
//            val sdf = SimpleDateFormat("dd/M/yyyy")
//            val currentDate = sdf.format(Date())
//            System.out.println(" Todays DATE is  "+currentDate)

        val jsonString: String
        // Open the asset file as an InputStream
//        val inputStream = requireContext().assets.open("rideinputdata.json")
//        // Open the asset file as an InputStream
//        val filePath = context?.filesDir?.absolutePath + File.separator + "rideinputdatatest.json"
//        val jsonObject = readJsonFromFilenew(this, filePath)
////        // Get the size of the file
////        val size = inputStream.available()
////        // Create a byte array to hold the data
////        val buffer = ByteArray(size)
////        // Read the data into the buffer
////        inputStream.read(buffer)
////        // Close the input stream
////        inputStream.close()
////        // Convert the byte array to a String
////        jsonString = String(buffer, Charsets.UTF_8)
//
//

        //-------------------------------------------


        if (count == 0) {

             count++

            val sampleJson = """
            [ 
            {
    "date_data": "26082025",
     "source_data": "Sec",
     "desti_data": "Armor",
     "time_data": "5Pm",
     "via_data":"Kamareddy"
  },
  {
    "date_data": "24082025",
    "source_data": "tgs",
    "desti_data": "Sec",
    "time_data": "2Pm",
    "via_data":"Kamareddy"
  }]"""
//
            // Write the JSON file
            writeJsonToFile(getContext(), fileName, sampleJson)

            //writeUserToJsonFile(getContext(), sampleJson, fileName2)
        }
            // Read the JSON file
            val jsonContent = readJsonFromFilenew(getContext(), fileName)

            // Parse the JSON content (e.g., using Gson)
//        jsonContent?.let {
//            val gson = Gson()
//            val myObject = gson.fromJson(jsonContent, RideData::class.java)
//            Log.d("JSON_READ", "Source: ${myObject.source_data}, via: ${myObject.via_data}")
//        }
            // jsonString=myObject.toString()
            //-------------------------------------------

        val gson = Gson()
        val listType = object : TypeToken<List<RideData>>() {}.type
        val itemList2: List<RideData> = gson.fromJson(jsonContent, listType)

        val adapter1 = MyCustomAdapter(requireContext(), itemList2 as MutableList<RideData>)
        listView.setAdapter(adapter1)

        listView.adapter = adapter1


        return view
    }


    //---------------------------------------------------------------------
    fun readJsonFromFilenew(context: Context?, fileName: String): String? {
        var content: String? = null
        var reader: BufferedReader? = null
        try {
            val inputStream = context?.openFileInput(fileName)
            reader = BufferedReader(InputStreamReader(inputStream))
            val sb = StringBuilder()
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                sb.append(line).append("\r\n")
            }
            content = sb.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            reader?.close()
        }
        return content
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

    //------------------------------------------------------------------------------------
    fun writeUserToJsonFile(context: Context?, sampleJson: String, filename: String) {
        val gson = Gson()
        val jsonString = gson.toJson(sampleJson)

        // Choose internal or external storage
        // For internal storage (app-specific, private):
        val file = File(context?.filesDir, filename)

        // For external storage (requires permissions, accessible by other apps):
        // val file = File(context.getExternalFilesDir(null), filename)

        try {
            FileOutputStream(file).use {
                it.write(jsonString.toByteArray())
            }
            println("Data written to JSON file: ${file.absolutePath}")
        } catch (e: Exception) {
            e.printStackTrace()
            println("Error writing data to JSON file: ${e.message}")
        }
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

