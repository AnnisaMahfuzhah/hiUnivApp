package com.example.hiunivapp

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiunivapp.network.Univ
import com.example.hiunivapp.ui.UnivApiStatus
import com.example.hiunivapp.ui.UnivListAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Univ>?) {
    val adapter = recyclerView.adapter as UnivListAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: UnivApiStatus?) {
    when(status) {
        UnivApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        UnivApiStatus.DONE -> {
            statusImageView.visibility = View.VISIBLE
        }
        UnivApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}