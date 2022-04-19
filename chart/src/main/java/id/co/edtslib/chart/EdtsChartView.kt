package id.co.edtslib.chart

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
abstract class EdtsChartView: WebView {
    var showLegend = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true
    }

    protected fun loadHtml(fDrawChart: String) {
        val html = "<html>\n" +
                "    <head>\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "        <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "        <script type=\"text/javascript\">\n" +
                "           google.charts.load('current', {'packages':['corechart', 'geochart']});" +
                "           google.charts.setOnLoadCallback(drawChart);" +
                "           function drawChart() { " +
                fDrawChart +
                "           } " +
                "        </script>\n" +
                "    </head>\n" +
                "<body><div id='dvChart' style='width: 100%; height: 100%;'></body>" +
                "</html>"
        loadData(html, "text/html", "UTF-8")

    }

    protected fun listChartDataToArray(list: List<ChartData>): List<List<Any>> {
        val mutableList = mutableListOf<List<Any>>()

        for (item in list) {
            val items = listOf<Any>(item.text, item.value)
            mutableList.add(items)
        }

        return mutableList.toList()

    }
}