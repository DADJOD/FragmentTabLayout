package com.example.fragmenttablayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private var toolbar: Toolbar? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager2? = null
    private var uiManager: MainActivityUIManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        viewPager = findViewById<View>(R.id.viewpager) as ViewPager2

        uiManager = MainActivityUIManager(this, toolbar!!, tabLayout!!, viewPager!!)
        uiManager?.setupViewPager()
    }
}