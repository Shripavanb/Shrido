package `in`.shrido.shrido

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
//    private fun replaceFragment(fragment: androidx.fragment.app.Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.content_framelayout, fragment )
//        fragmentTransaction.commit()
//    }

    override fun setContentView(layoutResID: Int) {

        val fullLayout = layoutInflater.inflate(R.layout.base_activity, null) as ViewGroup
        val headerContainer = fullLayout.findViewById<FrameLayout>(R.id.header_framelayout)
        val contentContainer = fullLayout.findViewById<FrameLayout>(R.id.content_framelayout)
        val navContainer = fullLayout.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.base_bottom_nav)




        // Inflate the header and add it to the header container
        LayoutInflater.from(this).inflate(R.layout.base_activity, headerContainer, true)

        // Inflate the activity's specific content and add it to the content container
        LayoutInflater.from(this).inflate(R.layout.base_activity, contentContainer, true)

        // Inflate the activity's specific content and add it to the content container
        LayoutInflater.from(this).inflate(R.layout.base_activity, navContainer, true)

        super.setContentView(fullLayout)
    }

}