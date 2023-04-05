package com.ashu.fooddeliverydemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ashu.fooddeliverydemo.fragment.HeatFragment
import com.ashu.fooddeliverydemo.fragment.OffersFragment
import com.ashu.fooddeliverydemo.fragment.PolishingFragment
import com.ashu.fooddeliverydemo.fragment.ProtectionFragment

private const val NUM_TABS = 4

class ViewpagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return HeatFragment()
            1 -> return ProtectionFragment()
            2 -> return PolishingFragment()
            3 -> return OffersFragment()
        }
        return HeatFragment()
    }
}