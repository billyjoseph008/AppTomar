package com.brainstormideas.apptomar.ui.fragments.client

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.brainstormideas.apptomar.databinding.FragmentClientOrdersHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientOrdersHistory : Fragment() {

    private var _binding: FragmentClientOrdersHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClientOrdersHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }
}