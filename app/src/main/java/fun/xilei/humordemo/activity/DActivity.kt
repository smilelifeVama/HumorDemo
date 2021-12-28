package `fun`.xilei.humordemo.activity

import android.os.Bundle
import com.humor.debugactivity.BaseDebugActivity
import com.humor.debugactivity.DemoButton

class DActivity :BaseDebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDemoButtons(DemoButton(this, "start A"){
            startDebugModule("", AActivity::class.java)
        }, DemoButton(this, "start B"){
            startDebugModule("", BActivity::class.java)
        }, DemoButton(this, "start C"){
            startDebugModule("", CActivity::class.java)
        })
        addDemoButtons(DemoButton(this, "start D"){
            startDebugModule("", DActivity::class.java)
        }, DemoButton(this, "start E"){
            startDebugModule("", EActivity::class.java)
        })
    }
}