package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import com.google.gson.Gson

open class HorizontalBarChartView: EdtsChartView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(label: String, chartData: List<ChartData>) {
        val json = Gson().toJson(listChartDataToArray(chartData))
        val drawChart = "" +
                "var data = new google.visualization.DataTable();" +
                "data.addColumn('string', 'col1');" +
                "javascript:data.addColumn('number', '$label');" +
                String.format("javascript:data.addRows(%s);", json) +
                "var options = {$showLegend defaultColor: 'red'};" +
                "var chart = new google.visualization.BarChart(document.getElementById('dvChart'));" +
                "chart.draw(data, options);"

        loadHtml(drawChart)
    }
}