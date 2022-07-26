package com.example.accuweather.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.accuweather.data.model.LocationDB
import com.example.accuweather.databinding.FragmentSearchBinding
import com.example.accuweather.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SearchFragment: Fragment(), SearchAdapter.SearchEvents {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter
    private val mainViewModel by sharedViewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SearchAdapter(this)
    }

    override fun onClickListener(locationDB: LocationDB) {
        mainViewModel.insertLocation(locationDB)
    }
}