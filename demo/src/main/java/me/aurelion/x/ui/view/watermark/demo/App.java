package me.aurelion.x.ui.view.watermark.demo;

import android.app.Application;
import android.graphics.Color;
import android.graphics.Paint;

import me.aurelion.x.ui.view.watermark.WaterMarkInfo;
import me.aurelion.x.ui.view.watermark.WaterMarkManager;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/24
 * <p>
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        WaterMarkManager.setInfo(
                WaterMarkInfo.create()
                        .setDegrees(-45)
                        .setTextSize(Utils.dp2px(getApplicationContext(), 20))
                        .setTextColor(Color.parseColor("#220000FF"))
                        .setTextBold(true)
                        .setDx(Utils.dp2px(getApplicationContext(), 60))
                        .setDy(Utils.dp2px(getApplicationContext(), 120))
                        .setAlign(Paint.Align.CENTER)
                        .generate());
        WaterMarkManager.setText("呵呵呵", "呵呵呵呵", "呵呵呵呵呵");
    }
}
