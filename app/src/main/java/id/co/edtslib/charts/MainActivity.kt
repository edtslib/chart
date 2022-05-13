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

        val pieChart = findViewById<PieChartView>(R.id.pieChart)
        pieChart.setData(listOf(
            ChartData("Mushrooms", 3.0),
            ChartData("Onions", 1.0),
            ChartData("Olives", 1.0),
            ChartData("Zucchini", 1.0),
            ChartData("Pepperoni", 2.0)))

        val donutChart = findViewById<PieChartView>(R.id.donutChart)
        donutChart.setData(listOf(
            ChartData("Work", 11.0),
            ChartData("Eat", 2.0),
            ChartData("Commute", 2.0),
            ChartData("Watch TV", 2.0),
            ChartData("Sleep", 7.0)))

        val geoId = findViewById<GeoIDView>(R.id.geoId)
        geoId.setData("Popularity", listOf(
            ChartData("ID-JK", 580.0),
            ChartData("ID-BA", 103.0),
            ChartData("ID-JB", 239.0),
            ChartData("ID-BT", 78.0),
            ChartData("ID-JT", 78.0)))

        val geo = findViewById<GeoView>(R.id.geo)
        geo.setData("Popularity", listOf(
            ChartData("Indonesia", 450.0),
            ChartData("Germany", 1000.0),
            ChartData("Denmark", 400.0),
            ChartData("France", 750.0),
            ChartData("Brazil", 1000.0)))
    }
}