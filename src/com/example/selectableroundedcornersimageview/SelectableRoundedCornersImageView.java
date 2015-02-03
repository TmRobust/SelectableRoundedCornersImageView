package com.example.selectableroundedcornersimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.selectableroundedcornersimageview.R;

public class SelectableRoundedCornersImageView extends ImageView
{
    private Path maskPath;

    private Paint maskPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    /** 
     * @Fields leftTopCornerRadius : 左上圆角
     */ 
    private float leftTopCornerRadius = 0f;

    /** 
     * @Fields rightTopCornerRadius : 右上圆角 
     */ 
    private float rightTopCornerRadius = 0f;

    /** 
     * @Fields leftBottomCornerRadius : 左下圆角
     */ 
    private float leftBottomCornerRadius = 0f;

    /** 
     * @Fields rightBottomCornerRadius : 右下原角
     */ 
    private float rightBottomCornerRadius = 0f;

    public SelectableRoundedCornersImageView(Context context)
    {
        super(context);
    }

    public SelectableRoundedCornersImageView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);
        setCornerRadiusFromAttribute(context, attributeSet);
    }

    public SelectableRoundedCornersImageView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        setCornerRadiusFromAttribute(context, attrs);
    }

    private void setCornerRadiusFromAttribute(Context context, AttributeSet attrs)
    {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SelectableRoundedCornersImageView);
        if (typedArray != null)
        {
            leftTopCornerRadius = typedArray.getDimension(R.styleable.SelectableRoundedCornersImageView_leftTopCornerRadius, 0f);
            rightTopCornerRadius = typedArray.getDimension(R.styleable.SelectableRoundedCornersImageView_rightTopCornerRadius, 0f);
            leftBottomCornerRadius = typedArray.getDimension(R.styleable.SelectableRoundedCornersImageView_leftBottomCornerRadius, 0f);
            rightBottomCornerRadius = typedArray.getDimension(R.styleable.SelectableRoundedCornersImageView_rightBottomCornerRadius, 0f);
        }
    }

    private void initPath(int width, int height)
    {
        ViewCompat.setLayerType(this, ViewCompat.LAYER_TYPE_SOFTWARE, null);

        maskPaint.setAntiAlias(true);
        maskPaint.setColor(0xff424242);
        maskPaint.setXfermode(new PorterDuffXfermode(Mode.DST_OUT));

        maskPath = new Path();
        // 图片四个角弧度半径数组,4对value 顺序为 左上、右上、右下、左下，
        float[] radius =
        { leftTopCornerRadius, leftTopCornerRadius, rightTopCornerRadius, rightTopCornerRadius, rightBottomCornerRadius, rightBottomCornerRadius,
                leftBottomCornerRadius, leftBottomCornerRadius };
        maskPath.addRoundRect(new RectF(0, 0, width, height), radius, Direction.CW);
        maskPath.setFillType(FillType.INVERSE_WINDING);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        int width = getLayoutParams().width;
        int height = getLayoutParams().height;
        initPath(width, height);

        // If canvas is opaque, make it transparent
        if (canvas.isOpaque())
        {
            canvas.saveLayerAlpha(0, 0, canvas.getWidth(), canvas.getHeight(), 255, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
        }

        super.onDraw(canvas);

        if (maskPath != null)
        {
            canvas.drawPath(maskPath, maskPaint);
        }

    }
}
