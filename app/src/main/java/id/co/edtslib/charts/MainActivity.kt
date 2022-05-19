package id.co.edtslib.charts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.edtslib.chart.*

class MainActivity : AppCompatActivity() {
    private var toast: Toast? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val geo = findViewById<GeoView>(R.id.geo)
        geo.setData("Popularity", listOf(
            ColumnData("Indonesia", 450.0),
            ColumnData("Germany", 1000.0),
            ColumnData("Denmark", 400.0),
            ColumnData("France", 750.0),
            ColumnData("Brazil", 1000.0)))

        val geoId = findViewById<GeoIDView>(R.id.geoId)
        geoId.setData("Popularity", listOf(
            ColumnData("ID-JK", 580.0),
            ColumnData("ID-BA", 103.0),
            ColumnData("ID-JB", 239.0),
            ColumnData("ID-BT", 78.0),
            ColumnData("ID-JT", 78.0)))

        val hBarChart = findViewById<HorizontalBarChartView>(R.id.hBarChart)
        hBarChart.setData(
            listOf(RowData("Data", listOf(
            ColumnData("Feb", 1.0),
            ColumnData("Mar", 2.0),
            ColumnData("Apr", 3.0),
            ColumnData("May", 4.0),
            ColumnData("Jun", 5.0),
            ColumnData("Jul", 6.0),
            ColumnData("Aug", 7.0),
            ColumnData("Sep", 8.0),
            ColumnData("Oct", 9.0)))))

        val barChart = findViewById<BarChartView>(R.id.barChart)
        barChart.setData(
            listOf(RowData("Data", listOf(
                ColumnData("Feb", 1.0),
                ColumnData("Mar", 2.0),
                ColumnData("Apr", 3.0),
                ColumnData("May", 4.0),
                ColumnData("Jun", 5.0),
                ColumnData("Jul", 6.0),
                ColumnData("Aug", 7.0),
                ColumnData("Sep", 8.0),
                ColumnData("Oct", 9.0)))))
    }
}