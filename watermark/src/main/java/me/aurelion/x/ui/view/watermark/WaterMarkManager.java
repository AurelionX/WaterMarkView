package me.aurelion.x.ui.view.watermark;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/24
 * <p>
 */
public class WaterMarkManager {

    static Context APPLICATION = null;
    static WaterMarkInfo INFO = null;
    static String CONTENT = "";
    static List<WaterMarkView> LIST = new ArrayList<>();

    /**
     * 初始化水印管理器
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        APPLICATION = context.getApplicationContext();
    }

    /**
     * 判断是否初始化
     */
    private static void assertInitialized() {
        if (APPLICATION == null) {
            throw new UnsupportedOperationException("You haven't initialized WaterMarkView yet!");
        }
        if (INFO == null) {
            INFO = WaterMarkInfo.create().generate();
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
     * @param activity activity
     */
    @SuppressLint("InflateParams")
    public static WaterMarkView getView(Activity activity) {
        assertInitialized();
        return (WaterMarkView) LayoutInflater.from(activity).inflate(R.layout.view_water_mark, null);
    }

    /**
     * 同步设置全部水印文字信息
     *
     * @param content 文字信息
     */
    public static void setText(String content) {
        assertInitialized();
        CONTENT = content == null ? "" : content;
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSyncText(content);
                }
            }
        }
    }

    /**
     * 同步设置全部水印倾斜角度
     *
     * @param degrees 倾斜角度
     */
    public static void setDegrees(int degrees) {
        assertInitialized();
        INFO.setDegrees(degrees);
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSyncDegrees(degrees);
                }
            }
        }
    }

    /**
     * 同步设置全部水印字体颜色
     *
     * @param textColor 字体颜色
     */
    public static void setTextColor(int textColor) {
        assertInitialized();
        INFO.setTextColor(textColor);
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSyncTextColor(textColor);
                }
            }
        }
    }

    /**
     * 同步设置全部水印字体大小
     *
     * @param textSize 字体大小
     */
    public static void setTextSize(int textSize) {
        assertInitialized();
        INFO.setTextSize(textSize);
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSyncTextSize(textSize);
                }
            }
        }
    }

    /**
     * 同步设置全部水印字体是否粗体
     *
     * @param textBold 是否粗体
     */
    public static void setTextBold(boolean textBold) {
        assertInitialized();
        INFO.setTextBold(textBold);
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSyncTextBold(textBold);
                }
            }
        }
    }

    /**
     * 同步设置全部水印X轴偏移量
     *
     * @param dx X轴偏移量
     */
    public static void setDx(int dx) {
        assertInitialized();
        INFO.setDx(dx);
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSyncDx(dx);
                }
            }
        }
    }

    /**
     * 同步设置全部水印Y轴偏移量
     *
     * @param dy Y轴偏移量
     */
    public static void setDy(int dy) {
        assertInitialized();
        INFO.setDy(dy);
        if (LIST.size() > 0) {
            for (WaterMarkView view : LIST) {
                if (view != null) {
                    view.setSignDy(dy);
                }
            }
        }
    }
}
