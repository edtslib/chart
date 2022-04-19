package id.co.edtslib.charts

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import id.co.edtslib.chart.*

class MainActivity : AppCompatActivity() {
    private var toast: Toast? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val donutChartView = findViewById<DonutChartView>(R.id.donut)
        donutChartView.setData(listOf(
            ChartData("Mushrooms", 3.0),
            ChartData("Onions", 1.0),
            ChartData("Olives", 1.0),
            ChartData("Zucchini", 1.0),
            ChartData("Pepperoni", 2.0)))
    }
}