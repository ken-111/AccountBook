package com.example.accountbook.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.accountbook.R
import com.example.accountbook.databinding.FragmentCalendarBinding
import com.example.accountbook.reference.DefineConstName
import com.example.accountbook.viewmodel.CalendarViewModel

class CalendarFragment : Fragment() {
    private lateinit var binding: FragmentCalendarBinding
    private val calendarView = CalendarViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_calendar, container, false
       )
        binding.calendarViewModel = calendarView
        binding.lifecycleOwner = this
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**ページ遷移する値を監視、クリックされた日付を渡す**/
        calendarView.onClickDate.observe(viewLifecycleOwner, {
            val fragmentManager = childFragmentManager
            if (fragmentManager != null) {
                getMainActivity()?.toDatePage(it)
            }
        })
    }
}
