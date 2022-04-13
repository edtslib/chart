package id.co.edtslib.charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.co.edtslib.chart.pie.PieChartListener
import id.co.edtslib.chart.pie.PieChartView

class MainActivity : AppCompatActivity() {
    private var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chartView = findViewById<PieChartView>(R.id.chartView)

        val percents = mutableListOf(45f, 19f, 14f, 22f)
        chartView.setPercent(percents)
        chartView.listener = object : PieChartListener {
            override fun onClick(index: Int) {
                toast?.cancel()

                toast = Toast.makeText(this@MainActivity, "abah ${percents[index]}", Toast.LENGTH_SHORT)
                toast?.show()
            }
        }
    }
}