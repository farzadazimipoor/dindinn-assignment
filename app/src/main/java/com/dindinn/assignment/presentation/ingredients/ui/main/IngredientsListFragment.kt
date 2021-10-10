package com.dindinn.assignment.presentation.ingredients.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.dindinn.assignment.R
import com.dindinn.assignment.common.Utils
import com.dindinn.assignment.common.binding.FragmentDataBindingComponent
import com.dindinn.assignment.common.helpers.AppExecutors
import com.dindinn.assignment.databinding.FragmentIngredientsBinding
import com.dindinn.assignment.di.Injectable
import javax.inject.Inject
import kotlin.math.floor


/**
 * A placeholder fragment containing a simple view.
 */
class IngredientsListFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    private var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    private lateinit var ingredientsViewModel: IngredientsViewModel

    private lateinit var binding: FragmentIngredientsBinding

    private lateinit var adapter: IngredientsListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_ingredients,
            container,
            false,
            dataBindingComponent
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ingredientsViewModel = ViewModelProvider(this, viewModelFactory).get(IngredientsViewModel::class.java)

        adapter = IngredientsListAdapter(appExecutors, dataBindingComponent)

        initRecyclerView()

        val categoryId = arguments?.getInt(ARG_CATEGORY_ID) ?: 1
        ingredientsViewModel.fetchIngredientsList(categoryId).observe(viewLifecycleOwner, {
            binding.resource = it
            adapter.submitList(it.data)
        })
    }

    private fun initRecyclerView() {
        val screenWidth = Utils.getScreenWidth(requireActivity())
        val colsCount = floor((screenWidth / 800).toDouble())
        binding.ordersRecyclerView.layoutManager = GridLayoutManager(context, colsCount.toInt())
        binding.ordersRecyclerView.adapter = adapter
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_CATEGORY_ID = "category_id"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(categoryId: Int): IngredientsListFragment {
            return IngredientsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_CATEGORY_ID, categoryId)
                }
            }
        }
    }
}