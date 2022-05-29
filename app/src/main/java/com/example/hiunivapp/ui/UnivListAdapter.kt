package com.example.hiunivapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiunivapp.databinding.ListViewItemBinding
import com.example.hiunivapp.network.Univ

class UnivListAdapter(val clickListener: UnivListener) :
    ListAdapter<Univ, UnivListAdapter.UnivViewHolder>(DiffCallback) {

    class UnivViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: UnivListener, univ: Univ) {
            binding.univ = univ
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Univ>() {

        override fun areItemsTheSame(oldItem: Univ, newItem: Univ): Boolean {
            return oldItem.alpha_two_code == newItem.alpha_two_code
        }

        override fun areContentsTheSame(oldItem: Univ, newItem: Univ): Boolean {
            return oldItem.name == newItem.name && oldItem.country == newItem.country && oldItem.domains == newItem.domains
                    && oldItem.stateprovince == newItem.stateprovince && oldItem.web_pages == newItem.web_pages
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UnivViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UnivViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UnivViewHolder, position: Int) {
        val univ = getItem(position)
        holder.bind(clickListener, univ)
    }
}

class UnivListener(val clickListener: (univ: Univ) -> Unit) {
    fun onClick(univ: Univ) = clickListener(univ)
}