package `fun`.xilei.humordemo.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import com.humor.debugactivity.BaseDebugActivity

open class TraceDebugActivity(val isTrace: Boolean = true) : BaseDebugActivity() {

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (isTrace) showLog("onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (isTrace) showLog("onRestoreInstanceState")
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        if (isTrace) showLog("onConfigurationChanged")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (isTrace) showLog("onCreate")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (isTrace) showLog("onNewIntent")
    }

    override fun onRestart() {
        super.onRestart()
        if (isTrace) showLog("onRestart")
    }

    override fun onStart() {
        super.onStart()
        if (isTrace) showLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        if (isTrace) showLog("onResume")
    }

    override fun onPause() {
        super.onPause()
        if (isTrace) showLog("onPause")
    }

    override fun onStop() {
        super.onStop()
        if (isTrace) showLog("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isTrace) showLog("onDestroy")
    }

}