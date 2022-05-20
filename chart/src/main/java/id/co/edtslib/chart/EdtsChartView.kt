package id.co.edtslib.chart

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import com.google.gson.Gson

@SuppressLint("SetJavaScriptEnabled")
abstract class EdtsChartView: WebView {
    var showLegend = ""
    var isStacked = ""
    var pieSliceTextStyle = ""
    var hole = ""


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

            val bIsStacked = a.getBoolean(R.styleable.EdtsChartView_isStacked, false)
            if (bIsStacked) {
                isStacked = "isStacked: true,"
            }

            val fontSize = a.getDimension(R.styleable.EdtsChartView_fontSize, 0f)
            if (fontSize > 0f) {
                pieSliceTextStyle = "pieSliceTextStyle: { fontSize: ${fontSize.toLong()},}, "
            }

            val fHole = a.getFloat(R.styleable.EdtsChartView_hole, 0f)
            if (fHole > 0f) {
                hole = "pieHole: $fHole, "
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
                "           google.charts.load('current', {'packages':['corechart', 'geochart', 'bar', 'treemap']});" +
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

    protected fun listChartDataToArray(list: List<ColumnData>): List<List<Any>> {
        val mutableList = mutableListOf<List<Any>>()

        for (item in list) {
            val items = listOf<Any>(item.text, item.value)
            mutableList.add(items)
        }

        return mutableList.toList()

    }

    protected open fun toJson(rowData: List<RowData>): String {
        val arr = mutableListOf<MutableList<Any>>()

        val row1 = mutableListOf<Any>("")
        for (row in rowData) {
            row1.add(row.label)
        }
        arr.add(row1)

        val map = mutableMapOf<String, MutableList<Double>>()
        for (row in rowData) {
            for (col in row.columns) {
                var ds = map[col.text]
                if (ds == null) {
                    ds = mutableListOf<Double>()
                    map[col.text] = ds
                }

                ds.add(col.value)
            }
        }

        for ((key, value) in map) {
            val row = mutableListOf<Any>(key)
            row.addAll(value)

            arr.add(row)
        }

        val json = Gson().toJson(arr)

        return json
    }
}