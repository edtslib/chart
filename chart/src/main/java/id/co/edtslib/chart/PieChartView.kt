package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import com.google.gson.Gson

open class PieChartView: EdtsChartView {
    var hole = 0.0
    var fontSize = 0.0

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(columnData: List<ColumnData>) {
        val sHole = "pieHole: $hole,"
        val sFontSize = if (fontSize == 0.0) "" else "pieSliceTextStyle: { fontSize: $fontSize,}"

        val json = Gson().toJson(listChartDataToArray(columnData))
        val drawChart = "" +
                "var data = new google.visualization.DataTable();" +
                "data.addColumn('string', 'col1');" +
                "javascript:data.addColumn('number', 'col2');" +
                String.format("javascript:data.addRows(%s);", json) +
                "var options = {$sHole $sFontSize};" +
                "var chart = new google.visualization.PieChart(document.getElementById('dvChart'));" +
                "chart.draw(data, options);"

        loadHtml(drawChart)
    }
}