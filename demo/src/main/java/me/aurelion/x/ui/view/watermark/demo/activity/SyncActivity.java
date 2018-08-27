package me.aurelion.x.ui.view.watermark.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.aurelion.x.ui.view.watermark.demo.R;
import me.aurelion.x.ui.view.watermark.demo.base.BaseActivity;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/27
 * <p>
 */
public class SyncActivity extends BaseActivity {

    public static Intent start(Context context) {
        Intent intent = new Intent(context, SyncActivity.class);
        context.startActivity(intent);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
    }
}
