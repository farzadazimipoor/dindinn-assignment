package com.dindinn.assignment.presentation.orders

import android.content.Intent
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dindinn.assignment.R
import com.dindinn.assignment.databinding.ActivityOrdersBinding
import com.dindinn.assignment.presentation.BaseActivity
import com.dindinn.assignment.presentation.ingredients.IngredientsActivity
import com.dindinn.assignment.presentation.orders.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class OrdersActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

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

        binding.ingredientsBtn?.setOnClickListener {
            val intent = Intent(this, IngredientsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}