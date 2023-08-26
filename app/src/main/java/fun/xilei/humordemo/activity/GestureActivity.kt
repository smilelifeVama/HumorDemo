package `fun`.xilei.humordemo.activity

import android.accessibilityservice.GestureDescription
import android.content.Intent
import android.graphics.Path
import android.os.Bundle
import android.provider.Settings
import com.humor.debugactivity.BaseDebugActivity
import com.humor.debugactivity.DemoButton
import com.humor.debugactivity.ScreenUtils
import `fun`.xilei.humordemo.service.MyAccessibilityService

class GestureActivity : BaseDebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (i in 1..30){
            addDemoButtons(DemoButton(this, "开启无障碍服务"){
                try {
                    val mIntent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
                    mIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(mIntent)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }, DemoButton(this, "往上滑"){
                slipUp()
            }, DemoButton(this, "往下滑"){
                slipDown()
            })
        }

    }

    private fun slipDown() {
        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)
        val builder = GestureDescription.Builder()
        val p = Path()
        p.moveTo((screenWidth / 2).toFloat(), (screenHeight / 2).toFloat())
        p.lineTo((screenWidth / 2).toFloat(), screenHeight.toFloat())
        builder.addStroke(GestureDescription.StrokeDescription(p, 0, 500))
        MyAccessibilityService.getInstance()?.doGesture(builder.build())
    }

    private fun slipUp() {
        val screenWidth = ScreenUtils.getScreenWidth(this)
        val screenHeight = ScreenUtils.getScreenHeight(this)
        val builder = GestureDescription.Builder()
        val p = Path()
        p.moveTo((screenWidth / 2).toFloat(), (screenHeight / 2).toFloat())
        p.lineTo((screenWidth / 2).toFloat(), 0F)
        builder.addStroke(GestureDescription.StrokeDescription(p, 0, 500))
        MyAccessibilityService.getInstance()?.doGesture(builder.build())
    }
}