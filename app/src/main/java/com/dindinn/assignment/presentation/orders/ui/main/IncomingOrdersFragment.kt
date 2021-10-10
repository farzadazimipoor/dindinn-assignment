package com.dindinn.assignment.presentation.orders.ui.main

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dindinn.assignment.R
import com.dindinn.assignment.common.binding.FragmentDataBindingComponent
import com.dindinn.assignment.common.helpers.AppExecutors
import com.dindinn.assignment.databinding.FragmentIncomingOrdersBinding
import com.dindinn.assignment.di.Injectable
import com.dindinn.assignment.presentation.common.GridSpacingItemDecoration
import javax.inject.Inject


/**
 * A placeholder fragment containing a simple view.
 */
class IncomingOrdersFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private lateinit var pageViewModel: PageViewModel

    private lateinit var binding: FragmentIncomingOrdersBinding

    private lateinit var ordersAdapter: OrdersListAdapter

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
        pageViewModel = ViewModelProvider(this, viewModelFactory).get(PageViewModel::class.java)

        ordersAdapter = OrdersListAdapter(appExecutors, dataBindingComponent)

        pageViewModel.fetchOrdersList(requireContext()).observe(viewLifecycleOwner, {
            binding.resource = it
            ordersAdapter.submitList(it.data)
        })

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(context, 3)
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.appbar_padding)
            binding.ordersRecyclerView.addItemDecoration(GridSpacingItemDecoration(spacingInPixels, 8, true, 4))
            binding.ordersRecyclerView.layoutManager = mLayoutManager
        } else {
            binding.ordersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
        binding.ordersRecyclerView.adapter = ordersAdapter
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