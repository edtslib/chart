package id.co.edtslib.chart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import id.co.edtslib.chart.PieChartView

class DonutChartView: PieChartView {
    private val wDonut = 100f
    private var path: Path? = null
    private var view: View? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun isValidPoint(x: Float, y: Float): Boolean {
        return if (path == null) {
            true
        } else {
            val rectF = RectF()
            path!!.computeBounds(rectF, false)
            ! (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom)
        }
    }

    fun setInformation(view: View) {
        if (this.view != null) {
            removeView(this.view)
        }

        this.view = view
        addView(view)

        val layoutParams = view.layoutParams as LayoutParams
        layoutParams.width = LayoutParams.WRAP_CONTENT
        layoutParams.height = LayoutParams.WRAP_CONTENT
        layoutParams.gravity = Gravity.CENTER
    }

    override fun drawX(canvas: Canvas?) {
        showLabel = false
        super.drawX(canvas)
    }

    override fun drawAddition(canvas: Canvas?) {
        paint.color = Color.WHITE

        path = Path()
        path?.addCircle(width/2.0f, height/2.0f, width/2.0f - wDonut,
            Path.Direction.CCW)

        canvas?.drawPath(path!!, paint)
    }
}