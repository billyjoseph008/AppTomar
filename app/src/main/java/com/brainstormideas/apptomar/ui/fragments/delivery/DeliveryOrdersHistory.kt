package com.brainstormideas.apptomar.ui.fragments.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.databinding.FragmentDeliveryOrdersHistoryBinding

class DeliveryOrdersHistory : Fragment() {

    private var _binding: FragmentDeliveryOrdersHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDeliveryOrdersHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}