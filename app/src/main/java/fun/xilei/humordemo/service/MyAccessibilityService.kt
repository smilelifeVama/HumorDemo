package `fun`.xilei.humordemo.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.accessibility.AccessibilityEvent


open class MyAccessibilityService : AccessibilityService() {
    companion object{
        private var instance: MyAccessibilityService? = null

        fun getInstance(): MyAccessibilityService? {
            return instance
        }

    }

    private val tag = "MyAccessibilityService::"

    private val gestureCallback = object: GestureResultCallback() {
        override fun onCancelled(gestureDescription: GestureDescription?) {
            super.onCancelled(gestureDescription)
        }

        override fun onCompleted(gestureDescription: GestureDescription?) {
            super.onCompleted(gestureDescription)
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.i(tag, "onAccessibilityEvent: $event")
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
        Log.i(tag, "onServiceConnected: ")
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(tag, "onServiceConnected: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tag, "onServiceConnected: ")
    }

    fun doGesture(gesture: GestureDescription) {
        dispatchGesture(gesture, gestureCallback, Handler(Looper.getMainLooper()))
    }

}