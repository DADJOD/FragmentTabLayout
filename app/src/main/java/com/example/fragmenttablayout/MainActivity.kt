package com.example.fragmenttablayout

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    // Виджеты
    private var toolbar: Toolbar? = null
    private var tabLayout: TabLayout? = null
    private var viewPager: ViewPager? = null
    private var adapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        tabLayout = findViewById<View>(R.id.tabs) as TabLayout
        viewPager = findViewById<View>(R.id.viewpager) as ViewPager

        // Устанавливаем Toolbar в качестве ActionBar
        // ActionBar удаляется с помощью темы в styles.xml
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Tab activity"
        tabLayout?.setupWithViewPager(viewPager)

        adapter = ViewPagerAdapter(supportFragmentManager)

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
    }

    // Цвета - целые числа
    // 0xaaccbbaa 0x - шестнадцатиричный ARGB Alpha Red Green Blue 00-ff
    // 0xccbbaa - без Alpha - полностью непрозрачный
    internal class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        // Контейнеры для фрагментов и заголовков табов
        private val titles: MutableList<String> = mutableListOf()
        private val fragments: MutableList<Fragment> = mutableListOf()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return titles[position]
        }

        // Добавление фрагментов во ViewPager
        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }
    }
}