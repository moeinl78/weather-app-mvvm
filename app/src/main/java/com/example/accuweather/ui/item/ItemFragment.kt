package com.example.accuweather.ui.item

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.accuweather.databinding.FragmentItemBinding
import com.example.accuweather.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ItemFragment: Fragment() {

    private lateinit var binding: FragmentItemBinding
    private val mainViewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}