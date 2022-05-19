package id.co.edtslib.chart

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

@SuppressLint("SetJavaScriptEnabled")
abstract class EdtsChartView: WebView {
    var showLegend = ""

    constructor(context: Context) : super(context) {
        init (null)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(attrs)
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(attrs)
    }


    private fun init(attrs: AttributeSet?) {
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.useWideViewPort = true
        settings.loadWithOverviewMode = true

        if (attrs != null) {
            val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.EdtsChartView,
                0, 0
            )

            val isShowLegend = a.getBoolean(R.styleable.EdtsChartView_showLegend, false)
            if (! isShowLegend) {
                showLegend = "legend: 'none',"
            }

            a.recycle()
        }
    }

    protected fun loadHtml(fDrawChart: String) {
        val html = "<html>\n" +
                "    <head>\n" +
                "        <meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width\">\n" +
                "        <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n" +
                "        <script type=\"text/javascript\">\n" +
                "           google.charts.load('current', {'packages':['corechart', 'geochart', 'bar']});" +
                "           google.charts.setOnLoadCallback(drawChart);" +
                "           function drawChart() { " +
                fDrawChart +
                "           } " +
                "        </script>\n" +
                "    </head>\n" +
                "<body style='margin:0;padding:0;'><div id='dvChart' style='width: 100%; height: 100%; margin: 0px;'></body>" +
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