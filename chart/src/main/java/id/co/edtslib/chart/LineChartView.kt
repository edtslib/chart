package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet

class LineChartView: EdtsChartView {
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
                "var chart = new google.visualization.LineChart(document.getElementById('dvChart'));" +
                "chart.draw(data, options);"

        loadHtml(drawChart)
    }
}