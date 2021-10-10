package com.dindinn.assignment.presentation.ingredients

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.dindinn.assignment.databinding.ActivityIngredientsBinding
import com.dindinn.assignment.presentation.BaseActivity
import com.dindinn.assignment.presentation.ingredients.ui.main.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class IngredientsActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var binding: ActivityIngredientsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIngredientsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

        binding.imgClose?.setOnClickListener {
            finish()
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}