package me.aurelion.x.ui.view.watermark.demo.base;

import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import me.aurelion.x.ui.view.watermark.WaterMarkManager;
import me.aurelion.x.ui.view.watermark.WaterMarkView;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/27
 * <p>
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected WaterMarkView mWmv;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        mWmv = WaterMarkManager.getView(this);
        ((ViewGroup) findViewById(android.R.id.content)).addView(mWmv);
    }

    @Override
    protected void onDestroy() {
        if (mWmv != null) {
            mWmv.onDestroy();
        }
        super.onDestroy();
    }
}
