package com.example.fragmenttablayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    // Виджеты
    private var toolbar: Toolbar? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager2? = null
    private var adapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        viewPager = findViewById<View>(R.id.viewpager) as ViewPager2

        // Устанавливаем Toolbar в качестве ActionBar
        // ActionBar удаляется с помощью темы в styles.xml
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Tab activity"
//        tabLayout?.setupWithViewPager(viewPager)

        adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        adapter?.addFragment(
            GenericFragment.newInstance(R.color.colorAccent, "First"), "First"
        )

        adapter?.addFragment(
            GenericFragment.newInstance(R.color.black, "Second"), "Second"
        )

        adapter?.addFragment(
            GenericFragment.newInstance(R.color.colorPrimaryDark, "Third"), "Third"
        )

        adapter?.addFragment(
            GenericFragment.newInstance(R.color.white, "Fourth"), "Fourth"
        )

        adapter?.addFragment(
            GenericFragment.newInstance(R.color.colorPrimary, "Fifth"), "Fifth"
        )

        viewPager?.adapter = adapter

        TabLayoutMediator(tabLayout!!, viewPager!!) { tab, pos ->
            tab.text = adapter?.getPageTitle(pos)
        }.attach()
    }

    internal class ViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
        FragmentStateAdapter(fm, lifecycle) {
        // Контейнеры для фрагментов и заголовков табов
        private val titles: MutableList<String> = mutableListOf()
        private val fragments: MutableList<Fragment> = mutableListOf()

//        override fun getItem(position: Int): Fragment {
//            return fragments[position]
//        }

//        override fun getCount(): Int {
//            return fragments.size
//        }

        override fun getItemCount(): Int {
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }

        fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }
    }
}