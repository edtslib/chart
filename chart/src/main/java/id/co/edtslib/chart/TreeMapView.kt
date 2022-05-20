package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import com.google.gson.Gson

class TreeMapView: EdtsChartView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(rowData: List<RowData>) {
        val data = toJson(rowData)

        val drawChart = "var data = google.visualization.arrayToDataTable($data);" +
                "var options = {$showLegend defaultColor: 'red', maxPostDepth: 3};" +
                "var chart = new google.visualization.TreeMap(document.getElementById('dvChart'));" +
                "chart.draw(data, options);"

        loadHtml(drawChart)
    }


    override fun toJson(rowData: List<RowData>): String {
        val arr = mutableListOf<MutableList<Any?>>()

        val row1 = mutableListOf<Any?>("Location", "Parent", "Data")
        arr.add(row1)

        val row4 = mutableListOf<Any?>("Global", null, 0)
        arr.add(row4)

        for (row in rowData) {
            val row2 = mutableListOf<Any?>(row.label, "Global", 0.0)
            arr.add(row2)

            for (col in row.columns) {
                val row3 = mutableListOf<Any?>(col.text, row.label, col.value)
                arr.add(row3)
            }
        }

        return Gson().toJson(arr)
    }
}