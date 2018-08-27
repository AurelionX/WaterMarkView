package me.aurelion.x.ui.view.watermark.demo;

import android.app.Application;
import android.graphics.Color;

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
                        .generate());
        WaterMarkManager.setText("哈哈哈哈哈哈哈");
    }
}
