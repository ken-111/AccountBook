package com.example.accountbook.viewmodel

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.accountbook.databinding.ListDataBinding
import com.example.accountbook.model.ListItemModel

private object DiffCallback : DiffUtil.ItemCallback<ListItemModel>() {
    override fun areItemsTheSame(oldItem: ListItemModel, newItem: ListItemModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ListItemModel, newItem: ListItemModel): Boolean {
        return oldItem == newItem
    }

}

class DateListAdapter(
    private val viewLifecycleOwner: LifecycleOwner,
    private val dateViewModel: DateViewModel
) : ListAdapter<ListItemModel, DateListAdapter.DateViewHolder>(DiffCallback) {

    class DateViewHolder(private val binding: ListDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItemModel, viewLifecycleOwner: LifecycleOwner, dateViewModel: DateViewModel) {
            binding.run {
                lifecycleOwner = viewLifecycleOwner
                listItemModel = item
                this.dateViewModel = dateViewModel

                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DateViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DateViewHolder(ListDataBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: DateViewHolder, position: Int) {
        holder.bind(getItem(position), viewLifecycleOwner, dateViewModel)
    }

}