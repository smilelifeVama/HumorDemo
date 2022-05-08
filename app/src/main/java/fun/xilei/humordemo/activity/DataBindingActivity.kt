package `fun`.xilei.humordemo.activity

import `fun`.xilei.humordemo.R
import `fun`.xilei.humordemo.bean.Person
import `fun`.xilei.humordemo.databinding.ActivityDataBindingBinding
import android.app.Activity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.humor.debugactivity.BaseDebugActivity

class DataBindingActivity : Activity(){
    lateinit var mViewBinding:ActivityDataBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding)
        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        mViewBinding.student = Person()
    }
}