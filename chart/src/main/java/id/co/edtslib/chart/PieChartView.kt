package id.co.edtslib.chart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.FrameLayout

open class PieChartView : FrameLayout {
    protected val paint = Paint()
    private val startAngle = 0f
    private var values: List<Float>? = null
    protected open fun drawAddition(canvas: Canvas?) {}

    companion object {
        val color = arrayListOf(Color.BLUE, Color.RED, Color.YELLOW)
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setData(values: List<Float>) {
        this.values = values
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (values?.isNotEmpty() == true) {
            val total = getTotal()
            if (total > 0) {

                paint.style = Paint.Style.FILL_AND_STROKE

                var remain = 360f
                var angle = startAngle
                for ((i, item) in values!!.withIndex()) {
                    val pct = item*360f/total
                    val sweepAngle = if (i+1 == values!!.size) remain else pct

                    remain -= pct

                    paint.color = color[i%color.size]

                    canvas?.drawArc(0f, 0f, width.toFloat(), height.toFloat(), angle, sweepAngle, true, paint)

                    angle += pct
                }




                paint.style = Paint.Style.FILL
                paint.color = Color.WHITE
            }

            drawAddition(canvas)
        }
    }

    private fun getTotal(): Float {
        var total = 0.0f
        if (values != null) {
            for (item in values!!) {
                total += item
            }
        }

        return total
    }
}