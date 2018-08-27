package me.aurelion.x.ui.view.watermark;

import android.content.Context;
import android.graphics.Color;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/24
 * <p>
 */
public class WaterMarkInfo {

    private int mDegrees;
    private int mTextColor;
    private int mTextSize;
    private int mDx;
    private int mDy;

    private WaterMarkInfo(int degrees, int textColor, int textSize, int dx, int dy) {
        mDegrees = degrees;
        mTextColor = textColor;
        mTextSize = textSize;
        mDx = dx;
        mDy = dy;
    }

    public int getDegrees() {
        return mDegrees;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public int getTextSize() {
        return mTextSize;
    }

    public int getDx() {
        return mDx;
    }

    public int getDy() {
        return mDy;
    }

    public static Builder create(Context context) {
        return new Builder(context);
    }

    public static class Builder {
        private Context mContext;
        private int mDegrees;
        private int mTextColor;
        private int mTextSize;
        private int mDx;
        private int mDy;

        private Builder(Context context) {
            mContext = context;
            mDegrees = -30;
            mTextColor = Color.parseColor("#33000000");
            mTextSize = WaterMarkUtil.dp2px(mContext, 20);
            mDx = WaterMarkUtil.dp2px(mContext, 50);
            mDy = WaterMarkUtil.dp2px(mContext, 120);
        }

        /**
         * 设置水印文字倾斜度
         *
         * @param degrees 文字倾斜度(默认:-30)
         * @return Builder
         */
        public Builder setDegrees(int degrees) {
            mDegrees = degrees;
            return this;
        }

        /**
         * 设置水印文字颜色
         *
         * @param textColor 文字颜色(默认:#33000000)
         * @return Builder
         */
        public Builder setTextColor(int textColor) {
            mTextColor = textColor;
            return this;
        }

        /**
         * 设置水印文字大小（单位：dp）
         *
         * @param textSize 文字大小(默认:20dp)
         * @return Builder
         */
        public Builder setTextSize(int textSize) {
            mTextSize = WaterMarkUtil.dp2px(mContext, textSize);
            return this;
        }

        /**
         * 设置水印文字X轴间距（单位：dp）
         *
         * @param dx 文字X轴间距(默认:50dp)
         * @return Builder
         */
        public Builder setDx(int dx) {
            mDx = WaterMarkUtil.dp2px(mContext, dx);
            return this;
        }

        /**
         * 设置水印文字Y轴间距（单位：dp）
         *
         * @param dy 文字Y轴间距(默认:120dp)
         * @return Builder
         */
        public Builder setDy(int dy) {
            mDy = WaterMarkUtil.dp2px(mContext, dy);
            return this;
        }

        /**
         * 生成水印全局配置信息
         *
         * @return 配置信息
         */
        public WaterMarkInfo generate() {
            return new WaterMarkInfo(mDegrees, mTextColor, mTextSize, mDx, mDy);
        }
    }

}
