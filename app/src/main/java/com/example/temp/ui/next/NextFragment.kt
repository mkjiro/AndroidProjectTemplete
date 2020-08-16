package com.example.temp.ui.next

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.temp.base.BaseFragment
import com.example.temp.databinding.FragmentNextBinding

class NextFragment : BaseFragment<NextEvents, NextViewModel>() {

    lateinit var binding: FragmentNextBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNextBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onLiveEventReceive(event: NextEvents) {

    }
}
