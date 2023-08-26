package `fun`.xilei.humordemo.activity

import `fun`.xilei.humordemo.adapter.TestAdapter
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.humor.debugactivity.BaseDebugActivity
import com.humor.debugactivity.DemoButton

class RecyclerViewTestActivity: BaseDebugActivity() {
    val datas = MutableList(10) { "$it" }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val relativeLayout = RelativeLayout(this)
        relativeLayout.setBackgroundColor(Color.CYAN)
//        relativeLayout.setPadding(100)
        relativeLayout.clipChildren = false
        relativeLayout.clipToPadding = false
//        relativeLayout.clipToOutline = false
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val rv = RecyclerView(this)
        rv.setBackgroundColor(Color.YELLOW)
//        rv.setPadding(200)
        rv.clipChildren = false
        rv.clipToPadding = false
//        rv.clipToOutline = false
        val params1 = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
        params1.addRule(RelativeLayout.CENTER_HORIZONTAL)
//        params1.leftMargin = 100
        relativeLayout.addView(rv, params1)
        addDemoButtons(DemoButton(this, "移除", View.OnClickListener {
            if (datas.isNotEmpty()) {
                datas.removeAt(1)
                rv.adapter?.notifyItemRemoved(1)
            }
        }))
        addView(relativeLayout, params)
        rv.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        rv.adapter = TestAdapter(datas)
    }
}