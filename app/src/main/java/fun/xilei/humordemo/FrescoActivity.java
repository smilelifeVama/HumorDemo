package fun.xilei.humordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.humor.debugactivity.BaseDebugActivity;
import com.humor.debugactivity.DemoButton;
import com.humor.debugactivity.ScreenUtils;

import java.util.concurrent.CountDownLatch;

public class FrescoActivity extends BaseDebugActivity {
    private String imgUrl = "https://p6-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/ae6231af235c41768cf6a187cde3bf08~tplv-k3u1fbpfcp-zoom-crop-mark:1304:1304:1304:734.awebp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Fresco.initialize(FrescoActivity.this);
        // final SimpleDraweeView simpleDraweeView = new SimpleDraweeView(this);
        // ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
        //         ViewGroup.LayoutParams.MATCH_PARENT, 800);
        // addView(simpleDraweeView, layoutParams);
        // addDemoButtons(new DemoButton(this, "loadImage", new View.OnClickListener() {
        //     @Override
        //     public void onClick(final View v) {
        //         simpleDraweeView.setImageURI(imgUrl);
        //         DraweeController draweeController = Fresco.newDraweeControllerBuilder().build();
        //         simpleDraweeView.setController();
        //     }
        // }), new DemoButton(this, ""));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        addDemoButtons(new DemoButton(this, "mock", v -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showTips("return result.");
        }), new DemoButton(this, "net data response", v -> {
            countDownLatch.countDown();
        }));
    }
}
