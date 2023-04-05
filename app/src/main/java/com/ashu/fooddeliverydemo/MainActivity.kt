package com.ashu.fooddeliverydemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ashu.fooddeliverydemo.adapter.ViewpagerAdapter
import com.ashu.fooddeliverydemo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.collapsingToolbar.title = "Wepo"

        val fgArray = arrayOf(
            "Heat rejection",
            "Protection",
            "Polishing & Detailing ",
            "Offers"
        )
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        val adapter = ViewpagerAdapter(supportFragmentManager,lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout,viewPager){tab,position->
            tab.text = fgArray[position]
        }.attach()


    }
}