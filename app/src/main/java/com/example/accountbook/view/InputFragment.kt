package com.example.accountbook.view

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.accountbook.R
import com.example.accountbook.databinding.FragmentInputBinding
import com.example.accountbook.reference.DefineConstName
import com.example.accountbook.reference.GlobalAccountModelData
import com.example.accountbook.viewmodel.InputViewModel

class InputFragment : Fragment() {
    private lateinit var binding: FragmentInputBinding
    private var inputView= InputViewModel(application = Application())
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_input, container, false
        )
        inputView = ViewModelProvider(this).get(InputViewModel::class.java)
        binding.inputViewModel = inputView
        binding.lifecycleOwner = activity
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**ページ遷移する値を監視**/
        inputView.toTopPage.observe(viewLifecycleOwner, {
            val fragmentManager = childFragmentManager
            if (fragmentManager != null) {

                getMainActivity()?.nextPage(DefineConstName.TOP_FRAGMENT)

            }
    })
}
}