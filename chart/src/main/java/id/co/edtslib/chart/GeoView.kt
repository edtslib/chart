package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import com.google.gson.Gson

open class GeoView: EdtsChartView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(chartData: List<ChartData>) {

        val json = Gson().toJson(listChartDataToArray(chartData))
        val drawChart = "" +
                "var data = new google.visualization.DataTable();" +
                "data.addColumn('string', 'Continent');" +
                "data.addColumn('number', 'col2');" +
                String.format("javascript:data.addRows(%s);", json) +
                "var options = { };" +
                "var chart = new google.visualization.GeoChart(document.getElementById('dvChart'));" +
                "chart.draw(data, options);"

        loadHtml(drawChart)
    }
}