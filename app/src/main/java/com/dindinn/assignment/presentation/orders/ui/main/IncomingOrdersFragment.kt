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
import com.dindinn.assignment.databinding.FragmentIncomingOrdersBinding
import com.dindinn.assignment.di.Injectable
import com.dindinn.assignment.domain.model.enums.Status
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class IncomingOrdersFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private lateinit var pageViewModel: PageViewModel

    private lateinit var binding: FragmentIncomingOrdersBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_incoming_orders,
            container,
            false,
            dataBindingComponent
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pageViewModel= ViewModelProvider(this, viewModelFactory).get(PageViewModel::class.java)

        pageViewModel.text.observe(viewLifecycleOwner, {
            binding.sectionLabel.text = it
        })

        pageViewModel.fetchOrdersList(requireContext()).observe(viewLifecycleOwner, {
            binding.resource = it
            if(it.status == Status.SUCCESS){
                binding.sectionLabel.text = "Number of orders: ${it.data?.size}"
            }
        })
    }

    companion object {
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(): IncomingOrdersFragment {
            return IncomingOrdersFragment()
        }
    }
}