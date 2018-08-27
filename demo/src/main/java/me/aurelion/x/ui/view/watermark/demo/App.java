package me.aurelion.x.ui.view.watermark.demo;

import android.app.Application;

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
        WaterMarkManager.init(this);
        WaterMarkManager.setText("哈哈哈哈哈哈哈");
    }
}
