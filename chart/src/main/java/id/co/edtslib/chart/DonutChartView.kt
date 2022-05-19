package id.co.edtslib.chart

import android.content.Context
import android.util.AttributeSet
import com.google.gson.Gson

class DonutChartView: PieChartView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        //hole = 0.6
        //fontSize = 7.5
    }
}