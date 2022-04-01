package id.co.edtslib.charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.co.edtslib.chart.PieChartView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chartView = findViewById<PieChartView>(R.id.chartView)
        chartView.setData(mutableListOf(10f, 40f, 50f))
    }
}