package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import com.google.gson.Gson

open class GeoIDView: EdtsChartView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(label: String, chartData: List<ChartData>) {

        val json = Gson().toJson(listChartDataToArray(chartData)).substring(1)
        val json1 = json.substring(0, json.length-1)

        val drawChart = "var data = google.visualization.arrayToDataTable([" +
                "          ['Province', '$label']," +
                json1 +
                "        ]);" +
                "        var options = {region: 'ID', displayMode: 'regions', resolution: 'provinces', colorAxis: {colors: ['blue']}};" +
                "        var chart = new google.visualization.GeoChart(document.getElementById('dvChart'));" +
                "        chart.draw(data, options);"

        loadHtml(drawChart)
    }
}