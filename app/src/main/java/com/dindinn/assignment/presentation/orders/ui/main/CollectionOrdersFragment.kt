package com.dindinn.assignment.presentation.orders.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dindinn.assignment.R
import com.dindinn.assignment.common.binding.FragmentDataBindingComponent
import com.dindinn.assignment.databinding.FragmentCollectionOrdersBinding
import com.dindinn.assignment.di.Injectable
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class CollectionOrdersFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private lateinit var pageViewModel: PageViewModel

    private lateinit var binding: FragmentCollectionOrdersBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_collection_orders,
            container,
            false,
            dataBindingComponent
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageViewModel= ViewModelProvider(this, viewModelFactory).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): CollectionOrdersFragment {
            return CollectionOrdersFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}