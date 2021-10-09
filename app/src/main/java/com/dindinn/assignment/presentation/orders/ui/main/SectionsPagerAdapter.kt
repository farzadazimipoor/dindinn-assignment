package com.dindinn.assignment.presentation.orders.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dindinn.assignment.R

private val TAB_TITLES = arrayOf(
    R.string.incoming_tab_text,
    R.string.preparing_tab_text,
    R.string.collection_tab_text
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        var fragment: Fragment = IncomingOrdersFragment.newInstance()
        if (position == 1) {
            fragment = PreparingOrdersFragment.newInstance(position + 1)
        } else if (position == 2) {
            fragment = CollectionOrdersFragment.newInstance(position + 1)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return TAB_TITLES.size
    }
}