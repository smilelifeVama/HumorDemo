package `fun`.xilei.humordemo.activity

import `fun`.xilei.humordemo.R
import `fun`.xilei.humordemo.view.AdView
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import android.view.ViewGroup
import com.humor.debugactivity.BaseDebugActivity
import com.humor.debugactivity.DemoButton
import com.humor.debugactivity.ScreenUtils

class FlvTestActivity : BaseDebugActivity() {
    private var mediaPlayer:MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var adView = AdView(this)
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ScreenUtils.px2dp(300))
        addView(adView, params)
        addDemoButtons(DemoButton(this, "init") {
            initPlayer()
        } , DemoButton(this, "play") {
            play()
        }, DemoButton(this, "stop") {
            stop()
        })
    }

    private fun stop() {
        mediaPlayer?.stop()
    }

    private fun play() {
        mediaPlayer?.start()
    }

    private fun initPlayer() {
//        mediaPlayer = MediaPlayer()
//        mediaPlayer?.setDisplay(surfaceView?.holder)
//        val des = assets.openFd("flv_video.flv")
//        mediaPlayer?.setDataSource(des)
//        mediaPlayer?.prepare()
    }
}