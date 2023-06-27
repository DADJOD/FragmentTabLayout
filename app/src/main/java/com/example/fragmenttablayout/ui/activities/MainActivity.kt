package com.example.fragmenttablayout.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.fragmenttablayout.domain.TabItem
import com.example.fragmenttablayout.ui.adapters.ViewPagerAdapter
import com.example.fragmenttablayout.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        tabLayout = findViewById(R.id.tabs)
        viewPager = findViewById(R.id.viewpager)

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Tab activity"

        val tabItems = listOf(
            TabItem("First", R.color.colorAccent),
            TabItem("Second", R.color.black),
            TabItem("Third", R.color.colorPrimaryDark),
            TabItem("Fourth", R.color.white),
            TabItem("Fifth", R.color.colorPrimary)
        )

        adapter = ViewPagerAdapter(this, tabItems)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabItems[position].title
        }.attach()
    }
}