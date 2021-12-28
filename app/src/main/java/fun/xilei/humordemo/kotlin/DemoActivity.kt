package `fun`.xilei.humordemo.kotlin

import `fun`.xilei.humordemo.R
import `fun`.xilei.humordemo.view.AdView
import android.content.Context
import android.graphics.Color
import android.graphics.PixelFormat
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.widget.ImageView
import com.humor.debugactivity.BaseDebugActivity
import com.humor.debugactivity.DemoButton

class DemoActivity: BaseDebugActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDemoButtons(DemoButton(this, "addView", View.OnClickListener {
            var windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager?
            val adView = AdView(this)
            val imageView = ImageView(this)
            imageView.setBackgroundColor(Color.CYAN)
            var params = WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                    WindowManager.LayoutParams.MATCH_PARENT)
            params.type = TYPE_APPLICATION_PANEL
            params.width = MATCH_PARENT
            params.height = MATCH_PARENT
            params.format = PixelFormat.TRANSLUCENT
            params.flags = FLAG_NOT_TOUCH_MODAL or FLAG_WATCH_OUTSIDE_TOUCH or FLAG_NOT_FOCUSABLE
            windowManager?.addView(adView, params)
        }), DemoButton(this, "getViews"){
            it.parent
        })
    }

}