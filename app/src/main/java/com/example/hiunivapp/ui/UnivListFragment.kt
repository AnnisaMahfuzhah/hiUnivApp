package com.example.hiunivapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.hiunivapp.databinding.FragmentUnivListBinding
import com.example.univapp.R
import com.example.univapp.databinding.FragmentUnivListBinding
import com.example.univapp.ui.UnivViewModel

class UnivListFragment : Fragment() {

    private val viewModel: UnivViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUnivListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = UnivListAdapter(UnivListener { univ ->
            viewModel.onUnivClicked(univ)
            findNavController()
                .navigate(R.id.action_univListFragment_to_univDetailFragment)
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}