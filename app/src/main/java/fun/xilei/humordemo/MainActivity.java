package fun.xilei.humordemo;

import android.os.Bundle;
import android.widget.TextView;

import com.humor.debugactivity.BaseDebugActivity;

public class MainActivity extends BaseDebugActivity {
    private StudentService.IUpdateLayout mIUpdateLayout = new StudentService.IUpdateLayout() {
        @Override
        public void showText(final String text) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(text);
                    addViews(textView);
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StudentService.setListener(mIUpdateLayout);
    }
}
