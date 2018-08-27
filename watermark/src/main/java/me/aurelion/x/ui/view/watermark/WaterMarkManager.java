package me.aurelion.x.ui.view.watermark;

import android.app.Activity;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/24
 * <p>
 */
public class WaterMarkManager {

    static String CONTENT = "";
    static WaterMarkInfo INFO = null;
    static List<WaterMarkView> LIST = new ArrayList<>();

    /**
     * 设置全部水印文字信息
     *
     * @param content 文字信息
     */
    public static void setText(String content) {
        if (content != null) {
            CONTENT = content;
            if (LIST.size() > 0) {
                for (WaterMarkView view : LIST) {
                    view.setWaterMarkText(content);
                }
            }
        }
    }

    /**
     * 设置水印全局配置信息
     *
     * @param info 配置信息
     */
    public static void setInfo(WaterMarkInfo info) {
        INFO = info;
    }

    /**
     * 获取一个满屏水印View
     *
     * @param activity
     */
    public static WaterMarkView getView(Activity activity) {
        return (WaterMarkView) LayoutInflater.from(activity).inflate(R.layout.view_water_mark, null);
    }
}
