package com.dindinn.assignment.presentation.orders.ui.main

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.dindinn.assignment.R
import com.dindinn.assignment.common.helpers.AppExecutors
import com.dindinn.assignment.databinding.OrderItemViewBinding
import com.dindinn.assignment.domain.model.OrderItem
import com.dindinn.assignment.presentation.common.DataBoundListAdapter
import com.dindinn.assignment.presentation.orders.OrdersActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.job
import java.text.SimpleDateFormat
import java.util.*

class OrdersListAdapter(
    appExecutors: AppExecutors,
    private val dataBindingComponent: DataBindingComponent
) : DataBoundListAdapter<OrderItem, OrderItemViewBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<OrderItem>() {
        override fun areItemsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: OrderItem, newItem: OrderItem): Boolean {
            return oldItem == newItem
        }
    }
) {
    override fun createBinding(parent: ViewGroup): OrderItemViewBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.order_item_view, parent, false, dataBindingComponent
        )
    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    override fun bind(binding: OrderItemViewBinding, item: OrderItem) {
        binding.txtOrderNo.text = item.no
        binding.txtOrderItems.text = "${item.quantity} Items"

        val dtf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        val alertDate = dtf.parse(item.alerted_at)
        val expireDate = dtf.parse(item.expired_at)

        val ticks: Long = if (item.id == 10) 47 else 20

        binding.progressBar.max = ticks.toInt()

        val job = tickerFlow(ticks).onEach {
            if (it == 0L) {
                currentCoroutineContext().job.cancel()
            }
            (binding.root.context as OrdersActivity).runOnUiThread {
                if (it == 0L) {
                    binding.button2.text = "Okay"
                    binding.button2.setTextColor(ContextCompat.getColor(binding.root.context, R.color.black))
                    binding.button2.backgroundTintList = ColorStateList.valueOf(Color.WHITE)
                    binding.txtRejectTitle.visibility = View.VISIBLE
                    Toast.makeText(binding.root.context, "${item.no} Completed", Toast.LENGTH_LONG).show()
                }
                binding.txtCounter.text = "${it}s"
                binding.progressBar.progress = it.toInt()
            }
        }.launchIn(GlobalScope)

        binding.button2.setOnClickListener {
            if (job.isActive) {
                job.cancel()
                Toast.makeText(binding.root.context, "${item.no} Cancelled", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun tickerFlow(totalSeconds: Long, period: Long = 1000, initialDelay: Long = 0) = flow {
        delay(initialDelay)
        var maxCounter = totalSeconds
        while (maxCounter >= 0) {
            emit(maxCounter)
            delay(period)
            maxCounter -= 1
        }
    }
}