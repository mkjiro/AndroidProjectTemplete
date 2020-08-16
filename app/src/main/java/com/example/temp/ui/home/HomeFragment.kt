package com.example.temp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.temp.R
import com.example.temp.base.BaseFragment
import com.example.temp.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeEvents, HomeViewModel>() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onLiveEventReceive(event: HomeEvents) {
        when (event) {
            is HomeEvents.ToNext -> {
                findNavController().navigate(R.id.next)
            }
        }
    }
}
