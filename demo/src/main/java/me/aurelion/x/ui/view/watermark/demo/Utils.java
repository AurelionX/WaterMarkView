package me.aurelion.x.ui.view.watermark.demo;

import android.content.Context;
import android.util.TypedValue;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/27
 * <p>
 */
public class Utils {

    public static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }
}
