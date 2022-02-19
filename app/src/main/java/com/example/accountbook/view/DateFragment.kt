package com.example.accountbook.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accountbook.databinding.FragmentDateBinding
import com.example.accountbook.viewmodel.DateListAdapter
import com.example.accountbook.viewmodel.DateViewModel


class DateFragment(selectedDate:String): Fragment() {


    private val date = selectedDate

    private val dateViewModel = DateViewModel(selectedDate)


    private lateinit var dateListAdapter: DateListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDateBinding.inflate(inflater, container, false)

            .apply {

                lifecycleOwner = viewLifecycleOwner

                list.run {
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

                    adapter = DateListAdapter(viewLifecycleOwner, this@DateFragment.dateViewModel).also {
                        dateListAdapter = it
                    }

                }
            }
            .run {
                root
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dateViewModel.run {
            dataList.observe(viewLifecycleOwner, {
                dateListAdapter.submitList(it)
            })

        }
    }
}


