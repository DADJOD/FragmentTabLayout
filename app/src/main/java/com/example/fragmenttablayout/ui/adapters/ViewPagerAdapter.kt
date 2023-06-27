package com.example.fragmenttablayout.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fragmenttablayout.domain.TabItem
import com.example.fragmenttablayout.ui.fragments.GenericFragment

class ViewPagerAdapter(
    activity: FragmentActivity,
    private val tabItems: List<TabItem>
) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return tabItems.size
    }

    override fun createFragment(position: Int): Fragment {
        val tabItem = tabItems[position]
        return GenericFragment.newInstance(tabItem.backgroundColor, tabItem.title)
    }
}