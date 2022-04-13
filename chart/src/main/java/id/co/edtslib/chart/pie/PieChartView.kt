package id.co.edtslib.chart.pie

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.widget.FrameLayout
import id.co.edtslib.chart.R


open class PieChartView : FrameLayout {
    var listener:  PieChartListener? = null
    var showLabel = true
    var labelColor = Color.WHITE
    var labelSize = 0f
    var borderWidth = 0f
    var borderColor = Color.WHITE

    protected val paint = Paint()

    private val startAngle = -90f
    private var paths = mutableListOf<Path>()

    private var percents: MutableList<Float>? = null
    protected open fun drawAddition(canvas: Canvas?) {}

    companion object {
        var colors = arrayListOf(Color.parseColor("#9C9DA6"),
            Color.parseColor("#1178D4"),
            Color.parseColor("#6CA5E0"),
            Color.parseColor("#FFA800"))
    }

    constructor(context: Context) : super(context)
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

    init {
        isClickable = true
    }

    private fun init(attrs: AttributeSet?) {
        if (attrs != null) {
            val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.PieChartView,
                0, 0
            )

            showLabel = a.getBoolean(R.styleable.PieChartView_showLabel, true)
            labelColor = a.getColor(R.styleable.PieChartView_labelColor, Color.WHITE)
            labelSize = a.getDimension(R.styleable.PieChartView_labelSize, 0f)

            borderWidth = a.getDimension(R.styleable.PieChartView_borderWidth, 0f)
            borderColor = a.getColor(R.styleable.PieChartView_borderColor, Color.WHITE)

            a.recycle()
        }
    }

    fun setValues(values: List<Float>) {
        percents = mutableListOf()

        var total = 0f
        for (f in values) {
            total += f
        }

        var totalPct = 0f
        for ((i, f) in values.withIndex()) {


            if (i+1 == values.size) {
                percents!!.add(100f-totalPct)
            }
            else {
                val pct = f*100f/total
                percents!!.add(pct)

                totalPct += pct
            }
        }
    }

    fun setPercent(percents: List<Float>) {
        this.percents = mutableListOf()
        this.percents!!.addAll(percents)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action) {
            MotionEvent.ACTION_UP -> {
                val x = event.x
                val y = event.y

                for ((i, path) in paths.withIndex()) {
                    val rectF = RectF()
                    path.computeBounds(rectF, true)
                    if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                        if (isValidPoint(x, y)) {
                            listener?.onClick(i)
                        }
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawX(canvas)

    }

    protected open fun isValidPoint(x: Float, y: Float) = true

    protected open fun drawX(canvas: Canvas?) {
        paths.clear()
        if (percents?.isNotEmpty() == true) {

            var angle = startAngle
            val rect = Rect()

            for ((i, item) in percents!!.withIndex()) {
                val sweepAngle = item*360f/100.0f

                val path = Path()
                path.addArc(RectF(0f, 0f, width.toFloat(), height.toFloat()), angle, sweepAngle)
                path.lineTo(width/2.0f, height/2.0f)

                paths.add(path)

                paint.style = Paint.Style.FILL
                paint.color = colors[i% colors.size]

                canvas?.drawPath(path, paint)

                if (borderWidth > 0f) {
                    paint.style = Paint.Style.STROKE
                    paint.strokeWidth = borderWidth
                    paint.color = Color.WHITE
                    canvas?.drawPath(path, paint)
                }

                if (showLabel) {
                    if (labelSize == 0f) {
                        labelSize = TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP,
                            17f, resources.displayMetrics
                        )
                    }

                    paint.style = Paint.Style.FILL
                    paint.textSize = labelSize
                    paint.color = labelColor

                    val bounds = RectF()
                    path.computeBounds(bounds, false)
                    val centerX: Float = bounds.centerX()
                    val centerY: Float = bounds.centerY()

                    val text = String.format("%.0f%%", item)
                    paint.getTextBounds(text, 0, text.length, rect)

                    //canvas?.drawText(String.format("%.0f%%", item), centerX, centerY, paint)
                    canvas?.drawText(
                        text,
                        centerX - rect.width() / 2.0f,
                        centerY + rect.height(),
                        paint
                    )
                }

                angle += sweepAngle
            }


            paint.style = Paint.Style.FILL
            paint.color = Color.WHITE

            drawAddition(canvas)
        }
    }
}