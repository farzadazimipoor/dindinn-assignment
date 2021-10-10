package com.dindinn.assignment.presentation.ingredients.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.dindinn.assignment.R
import com.dindinn.assignment.common.helpers.AppExecutors
import com.dindinn.assignment.databinding.IngredientItemViewBinding
import com.dindinn.assignment.domain.model.IngredientItem
import com.dindinn.assignment.presentation.common.DataBoundListAdapter

class IngredientsListAdapter(
    appExecutors: AppExecutors,
    private val dataBindingComponent: DataBindingComponent
) : DataBoundListAdapter<IngredientItem, IngredientItemViewBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<IngredientItem>() {
        override fun areItemsTheSame(oldItem: IngredientItem, newItem: IngredientItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: IngredientItem, newItem: IngredientItem): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun createBinding(parent: ViewGroup): IngredientItemViewBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.ingredient_item_view, parent, false, dataBindingComponent
        )
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun bind(binding: IngredientItemViewBinding, item: IngredientItem) {
        Glide.with(binding.root.context).load(item.photo).into(binding.imageView)
        binding.txtTitle.text = item.title
        binding.txtAvailableCount.text = item.availableCount.toString()

        if (item.availableCount <= 5) {
            with(binding) {
                txtAvailableTitle.background = ContextCompat.getDrawable(binding.root.context, R.drawable.card_not_available_header_background)
                txtAvailableCount.background = ContextCompat.getDrawable(binding.root.context, R.drawable.card_not_available_body_background)
            }
        }
    }
}