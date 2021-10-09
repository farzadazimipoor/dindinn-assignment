package com.dindinn.assignment.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.dindinn.assignment.R
import com.dindinn.assignment.common.binding.FragmentDataBindingComponent
import com.dindinn.assignment.common.helpers.AppExecutors
import com.dindinn.assignment.databinding.MainFragmentBinding
import com.dindinn.assignment.di.Injectable
import com.dindinn.assignment.domain.model.enums.Status
import javax.inject.Inject

class MainFragment : Fragment(), Injectable {

    companion object {
        fun newInstance() = MainFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private lateinit var binding: MainFragmentBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false,
            dataBindingComponent
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.fetchOrdersList(requireContext()).observe(viewLifecycleOwner, {
            binding.resource = it
            if (it.status == Status.SUCCESS) {
                Toast.makeText(requireContext(), "Orders: ${it.data?.size}", Toast.LENGTH_LONG).show()
            }
        })
    }
}