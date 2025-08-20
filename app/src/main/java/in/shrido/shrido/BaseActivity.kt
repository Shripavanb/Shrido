package `in`.shrido.shrido

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import `in`.shrido.shrido.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        val fullLayout = layoutInflater.inflate(R.layout.header_main, null) as ViewGroup
        val headerContainer = fullLayout.findViewById<FrameLayout>(R.id.header_framelayout)
        val contentContainer = fullLayout.findViewById<FrameLayout>(R.id.content_framelayout)
        val navContainer = fullLayout.findViewById<FrameLayout>(R.id.nav_framelayout)

        // Inflate the header and add it to the header container
        LayoutInflater.from(this).inflate(R.layout.header_main, headerContainer, true)

        // Inflate the activity's specific content and add it to the content container
        LayoutInflater.from(this).inflate(R.layout.header_main, contentContainer, true)

        // Inflate the activity's specific content and add it to the content container
        LayoutInflater.from(this).inflate(R.layout.header_main, navContainer, true)

        super.setContentView(fullLayout)
    }
}