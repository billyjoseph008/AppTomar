package com.brainstormideas.apptomar.ui.fragments.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.brainstormideas.apptomar.databinding.FragmentClientNewOrderBinding
import com.brainstormideas.apptomar.ui.viewmodel.StoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewOrder : Fragment() {

    private var _binding: FragmentClientNewOrderBinding? = null
    private val binding get() = _binding!!

    private val storeViewModel: StoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientNewOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeViewModel.isLoading.observe(requireActivity(), Observer { loading ->
            binding.progressBar.isVisible = loading
        })

        storeViewModel.storesModel.observe(requireActivity(), Observer { stores ->

        })
    }
}