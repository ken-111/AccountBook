package com.example.accountbook.view

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.accountbook.R
import com.example.accountbook.databinding.FragmentTopBinding
import com.example.accountbook.reference.DefineConstName.Companion.INPUT_FRAGMENT
import com.example.accountbook.reference.GlobalSetting
import com.example.accountbook.viewmodel.TopViewModel


class TopFragment : Fragment() {
    private lateinit var binding: FragmentTopBinding
    private val topView= TopViewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_top, container, false
        )
        binding.topViewModel = topView
        binding.lifecycleOwner = activity
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        topView.toInputPage.observe(viewLifecycleOwner, {
            val fragmentManager = childFragmentManager
            if (fragmentManager != null) {

                getMainActivity()?.nextPage(INPUT_FRAGMENT)

            }
        })
    }
}




