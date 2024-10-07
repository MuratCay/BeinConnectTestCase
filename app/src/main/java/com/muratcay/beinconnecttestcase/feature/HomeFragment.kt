package com.muratcay.beinconnecttestcase.feature

import com.muratcay.beinconnecttestcase.R
import com.muratcay.beinconnecttestcase.databinding.FragmentHomeBinding
import com.muratcay.presentation.base.BaseFragment
import com.muratcay.presentation.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(R.layout.fragment_home) {

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun initObserver() {

    }

    override fun initViews() {

    }
}