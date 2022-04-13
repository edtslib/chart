package id.co.edtslib.charts

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import id.co.edtslib.chart.DonutChartView
import id.co.edtslib.chart.EdtsChartListener

class MainActivity : AppCompatActivity() {
    private var toast: Toast? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = TextView(this)
        textView.setTextColor(Color.BLACK)
        textView.text = "1.1M"

        val chartView = findViewById<DonutChartView>(R.id.chartView)
        chartView.setInformation(textView)

        val percents = mutableListOf(45f, 19f, 14f, 22f)
        chartView.setPercent(percents)
        chartView.listener = object : EdtsChartListener {
            override fun onClick(index: Int) {
                toast?.cancel()

                toast = Toast.makeText(this@MainActivity, "abah ${percents[index]}", Toast.LENGTH_SHORT)
                toast?.show()
            }
        }
    }
}