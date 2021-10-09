package com.dindinn.assignment.presentation.orders

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.dindinn.assignment.databinding.ActivityOrdersBinding
import com.dindinn.assignment.presentation.orders.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class OrdersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrdersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOrdersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }
}