package me.aurelion.x.ui.view.watermark.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import me.aurelion.x.ui.view.watermark.demo.R;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/27
 * <p>
 */
public class NoSyncActivity extends AppCompatActivity {

    public static Intent start(Context context) {
        Intent intent = new Intent(context, NoSyncActivity.class);
        context.startActivity(intent);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync_no);
    }
}
