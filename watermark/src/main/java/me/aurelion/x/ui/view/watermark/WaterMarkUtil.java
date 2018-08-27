package me.aurelion.x.ui.view.watermark;

import android.content.Context;
import android.util.TypedValue;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/24
 * <p>
 */
class WaterMarkUtil {

    static int dp2px(Context context, float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.getResources().getDisplayMetrics());
    }

}
