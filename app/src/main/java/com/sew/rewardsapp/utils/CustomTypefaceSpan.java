package com.sew.rewardsapp.utils;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

import com.sew.rewardsapp.R;

/**
 * Created by siddharthkumar on 2/2/18.
 */

public class CustomTypefaceSpan extends TypefaceSpan {

    private final Typeface newType;
    private static int color;

    public CustomTypefaceSpan(String family, Typeface type, int color) {
        super(family);
        newType = type;
        this.color = color;
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, newType);
    }

    @Override
    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface tf) {
        int oldStyle;
        Typeface old = paint.getTypeface();
        if (old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int fake = oldStyle & ~tf.getStyle();
        if ((fake & Typeface.BOLD) != 0) {
            paint.setFakeBoldText(true);
        }

        if ((fake & Typeface.ITALIC) != 0) {
            paint.setTextSkewX(-0.25f);
        }
        //paint.setTextSize(R.dimen.nav_text_size);
        paint.setTypeface(tf);
        paint.setTextSize(60);
        paint.setColor(color);

    }
}