package com.example.accountbook.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.accountbook.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.data.PieDataSet as PieDataSet1

class GraphFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_graph, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val values = listOf(1f, 2f, 3f, 4f)//分割円の大きさ(Float型)
        val sampleData: List<Int> = listOf(10, 20, 20, 30)
        val sampleLabel: List<String> = listOf("緑", "青", "赤", "灰")
        val pieEntryList: List<PieEntry> = sampleData.zip(sampleLabel).map {
            PieEntry(it.first.toFloat(), it.second)
        }
        val pieDataSet = PieDataSet1(pieEntryList, "label")
        pieDataSet.colors = listOf(Color.GREEN, Color.BLUE, Color.RED, Color.GRAY)
        val pieData = PieData(pieDataSet)
        var mypiechart=view.findViewById<PieChart>(R.id.pieChartExample)
        mypiechart.data = pieData
     }
}