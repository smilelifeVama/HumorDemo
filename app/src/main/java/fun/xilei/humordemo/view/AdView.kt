package `fun`.xilei.humordemo.view

import `fun`.xilei.humordemo.R
import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView

class AdView : RelativeLayout {
    private var textCountDown:TextView? = null
    private var textOk:TextView? = null
    private var imageView:ImageView? = null

    constructor(context: Context) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private fun init() {
        val view = LayoutInflater.from(context).inflate(R.layout.view_ad, this, true)
        textCountDown = view.findViewById(R.id.tv_ad_count_down)
        textOk = view.findViewById(R.id.tv_ad_ok)
        imageView = view.findViewById(R.id.iv_ad)
        imageView?.setBackgroundColor(Color.GRAY)
    }


}