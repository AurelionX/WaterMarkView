package me.aurelion.x.ui.view.watermark.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import me.aurelion.x.ui.view.watermark.WaterMarkManager;
import me.aurelion.x.ui.view.watermark.WaterMarkView;

public class MainActivity extends AppCompatActivity {

    private WaterMarkView mWmv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
