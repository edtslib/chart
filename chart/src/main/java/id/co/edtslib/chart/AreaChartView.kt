package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import com.google.gson.Gson

class AreaChartView: EdtsChartView {
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
                "var options = {$showLegend defaultColor: 'red', $isStacked};" +
                "var chart = new google.visualization.AreaChart(document.getElementById('dvChart'));" +
                "chart.draw(data, options);"

        loadHtml(drawChart)
    }
}