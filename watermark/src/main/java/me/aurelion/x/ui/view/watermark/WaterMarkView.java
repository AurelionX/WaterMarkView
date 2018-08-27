package me.aurelion.x.ui.view.watermark;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author Leon (wshk729@163.com)
 * @date 2018/8/24
 * <p>
 */
public class WaterMarkView extends View {

    private TextPaint mTextPaint = new TextPaint();

    private String mText = WaterMarkManager.CONTENT;
    private int mDegrees;
    private int mTextColor;
    private int mTextSize;
    private int mDx;
    private int mDy;
    private int textWidth, textHeight;

    public WaterMarkView(Context context) {
        this(context, null);
    }

    public WaterMarkView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WaterMarkView);
        mDegrees = typedArray.getInt(R.styleable.WaterMarkView_degree, WaterMarkManager.INFO != null ? WaterMarkManager.INFO.getDegrees() : -30);
        mTextColor = typedArray.getColor(R.styleable.WaterMarkView_textColor, WaterMarkManager.INFO != null ? WaterMarkManager.INFO.getTextColor() : Color.parseColor("#33000000"));
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.WaterMarkView_textSize, WaterMarkManager.INFO != null ? WaterMarkManager.INFO.getTextSize() : WaterMarkUtil.dp2px(context, 20));
        mDx = typedArray.getDimensionPixelSize(R.styleable.WaterMarkView_dx, WaterMarkManager.INFO != null ? WaterMarkManager.INFO.getDx() : WaterMarkUtil.dp2px(context, 50));
        mDy = typedArray.getDimensionPixelSize(R.styleable.WaterMarkView_dy, WaterMarkManager.INFO != null ? WaterMarkManager.INFO.getDy() : WaterMarkUtil.dp2px(context, 120));
        typedArray.recycle();

        setBackgroundColor(Color.parseColor("#00000000"));
        mTextPaint.setAntiAlias(true);
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);
        if (!TextUtils.isEmpty(mText)) {
            Rect tvRect = new Rect();
            mTextPaint.getTextBounds(mText, 0, mText.length(), tvRect);
            textWidth = tvRect.width();
            textHeight = tvRect.height();
        }

        WaterMarkManager.LIST.add(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //        if (TextUtils.isEmpty(mText)) {
        //            return;
        //        }

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        if (measuredWidth == 0 || measuredHeight == 0) {
            return;
        }

        int canvasLength = measuredWidth > measuredHeight ? measuredWidth : measuredHeight;

        canvas.rotate(mDegrees, measuredWidth / 2, measuredHeight / 2);

        int ylocation = (measuredHeight - canvasLength) / 2;

        while (ylocation < canvasLength - (measuredHeight - canvasLength) / 2) {
            canvas.save();
            int xlocation = (measuredWidth - canvasLength) / 2;

            while (xlocation < canvasLength - (measuredWidth - canvasLength) / 2) {

                canvas.drawText(mText, xlocation, ylocation, mTextPaint);
                xlocation = xlocation + textWidth + mDx;
            }

            ylocation = ylocation + textHeight + mDy;
            canvas.restore();
        }
    }

    /**
     * 设置水印文字内容
     *
     * @param text 文字内容
     */
    public void setWaterMarkText(String text) {
        mText = text;

        Rect tvRect = new Rect();
        mTextPaint.getTextBounds(mText, 0, mText.length(), tvRect);
        textWidth = tvRect.width();
        textHeight = tvRect.height();
        postInvalidate();
    }

    /**
     * 设置水印倾斜角度
     *
     * @param degrees 倾斜角度
     */
    public void setDegrees(int degrees) {
        mDegrees = degrees;
        postInvalidate();
    }

    /**
     * 设置水印字体颜色
     *
     * @param textColor 字体颜色
     */
    public void setTextColor(int textColor) {
        mTextColor = textColor;
        postInvalidate();
    }

    /**
     * 设置水印字体大小
     *
     * @param textSize 字体大小
     */
    public void setTextSize(int textSize) {
        mTextSize = WaterMarkUtil.dp2px(getContext(), textSize);
        postInvalidate();
    }

    /**
     * 设置水印X轴偏移量
     *
     * @param dx X轴偏移量
     */
    public void setDx(int dx) {
        this.mDx = WaterMarkUtil.dp2px(getContext(), dx);
        postInvalidate();
    }

    /**
     * 设置水印Y轴偏移量
     *
     * @param dy Y轴偏移量
     */
    public void setDy(int dy) {
        this.mDy = WaterMarkUtil.dp2px(getContext(), dy);
        postInvalidate();
    }

    /**
     * 销毁相关页面时调用（切记）
     */
    public void onDestroy() {
        WaterMarkManager.LIST.remove(this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}