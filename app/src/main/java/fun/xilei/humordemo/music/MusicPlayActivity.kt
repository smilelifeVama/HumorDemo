package `fun`.xilei.humordemo.music

import `fun`.xilei.humordemo.R
import `fun`.xilei.humordemo.databinding.MusicPlayActivityBinding
import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class MusicPlayActivity : Activity(){
    lateinit var binding:MusicPlayActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.music_play_activity)
        binding = DataBindingUtil.setContentView(this, R.layout.music_play_activity)
        binding.model = MusicPlayModel()
    }
}