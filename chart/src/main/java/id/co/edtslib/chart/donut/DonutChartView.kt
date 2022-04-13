package id.co.edtslib.chart.donut

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import id.co.edtslib.chart.pie.PieChartView

class DonutChartView: PieChartView {
    private val wDonut = 100f

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun drawX(canvas: Canvas?) {
        showLabel = false
        super.drawX(canvas)
    }

    override fun drawAddition(canvas: Canvas?) {
        paint.color = Color.WHITE

        val x1 = width/2.0f
        val y1 = height/2.0f
        val r1 = width/2.0f - wDonut

        canvas?.drawCircle(x1, y1, r1, paint)
    }
}