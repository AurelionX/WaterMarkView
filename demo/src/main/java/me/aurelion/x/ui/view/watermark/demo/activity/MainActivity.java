package me.aurelion.x.ui.view.watermark.demo.activity;

import android.os.Bundle;
import android.view.View;

import me.aurelion.x.ui.view.watermark.WaterMarkManager;
import me.aurelion.x.ui.view.watermark.demo.R;
import me.aurelion.x.ui.view.watermark.demo.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
        findViewById(R.id.btn5).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                WaterMarkManager.setText("你瞅啥");
                break;
            case R.id.btn2:
                WaterMarkManager.setText("瞅你咋地");
                break;
            case R.id.btn3:
                WaterMarkManager.setText("");
                break;
            case R.id.btn4:
                SyncActivity.start(this);
                break;
            case R.id.btn5:
                NoSyncActivity.start(this);
                break;

        }
    }
}
