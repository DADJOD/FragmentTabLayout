package com.example.fragmenttablayout

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivityUIManager(
    private val activity: AppCompatActivity,
    toolbar: Toolbar,
    private val tabLayout: TabLayout,
    private val viewPager: ViewPager2,
) {
    private var adapter: ViewPagerAdapter? = null

    init {
        activity.setSupportActionBar(toolbar)
        activity.supportActionBar?.title = "Tab activity"
    }

    fun setupViewPager() {

        adapter = ViewPagerAdapter()

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

        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->
            tab.text = adapter?.getPageTitle(pos)
        }.attach()
    }

    private inner class ViewPagerAdapter :
        FragmentStateAdapter(activity) {
        // Контейнеры для фрагментов и заголовков табов
        private val titles: MutableList<String> = mutableListOf()
        private val fragments: MutableList<Fragment> = mutableListOf()

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

