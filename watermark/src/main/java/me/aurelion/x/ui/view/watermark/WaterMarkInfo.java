package me.aurelion.x.ui.view.watermark;

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
    private boolean mTextBold;
    private int mDx;
    private int mDy;

    private WaterMarkInfo(int degrees, int textColor, int textSize, boolean textBold, int dx, int dy) {
        mDegrees = degrees;
        mTextColor = textColor;
        mTextSize = textSize;
        mTextBold = textBold;
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

    public boolean isTextBold() {
        return mTextBold;
    }

    void setDegrees(int degrees) {
        mDegrees = degrees;
    }

    void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    void setTextSize(int textSize) {
        mTextSize = textSize;
    }

    void setTextBold(boolean textBold) {
        mTextBold = textBold;
    }

    void setDx(int dx) {
        mDx = WaterMarkUtil.dp2px(dx);
    }

    void setDy(int dy) {
        mDy = WaterMarkUtil.dp2px(dy);
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private int mDegrees;
        private int mTextColor;
        private int mTextSize;
        private boolean mTextBold;
        private int mDx;
        private int mDy;

        private Builder() {
            mDegrees = -30;
            mTextColor = Color.parseColor("#33000000");
            mTextSize = WaterMarkUtil.dp2px(20);
            mTextBold = false;
            mDx = WaterMarkUtil.dp2px(50);
            mDy = WaterMarkUtil.dp2px(120);
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
            mTextSize = WaterMarkUtil.dp2px(textSize);
            return this;
        }

        /**
         * 设置水印文字是否加粗
         *
         * @param textBold 文字加粗(默认:不加粗)
         * @return Builder
         */
        public Builder setBold(boolean textBold) {
            mTextBold = textBold;
            return this;
        }

        /**
         * 设置水印文字X轴间距（单位：dp）
         *
         * @param dx 文字X轴间距(默认:50dp)
         * @return Builder
         */
        public Builder setDx(int dx) {
            mDx = WaterMarkUtil.dp2px(dx);
            return this;
        }

        /**
         * 设置水印文字Y轴间距（单位：dp）
         *
         * @param dy 文字Y轴间距(默认:120dp)
         * @return Builder
         */
        public Builder setDy(int dy) {
            mDy = WaterMarkUtil.dp2px(dy);
            return this;
        }

        /**
         * 生成水印全局配置信息
         *
         * @return 配置信息
         */
        public WaterMarkInfo generate() {
            return new WaterMarkInfo(mDegrees, mTextColor, mTextSize, mTextBold, mDx, mDy);
        }
    }

}
