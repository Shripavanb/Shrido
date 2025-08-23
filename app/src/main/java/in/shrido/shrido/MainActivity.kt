package `in`.shrido.shrido


import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.EditText

import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.android.identity.cbor.DataItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.SimpleTimeZone
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import `in`.shrido.shrido.databinding.ActivityMainBinding
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set initial fragment
        if (savedInstanceState == null) {
            replaceFragment(Home())
        }

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    replaceFragment(Home())
                    true
                }
                R.id.profile -> {
                    replaceFragment(Profile())
                    true
                }
                R.id.settings -> {
                    replaceFragment(Settings())
                    true
                }
                else -> false
            }
        }

    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun Onclick_Search(view: View) {
        val source= findViewById<EditText>(R.id.Source)
        val Dest = findViewById<EditText>(R.id.Destination)

        //val myData = RideData.RideDetails( sourcetext.toString(),desttext.toString())
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.newmenu)
        return super.onCreateOptionsMenu(menu)
    }

    fun Contact_onClick(view: View) {

    }
}

private fun MenuInflater.inflate(menuRes: Int) {}
