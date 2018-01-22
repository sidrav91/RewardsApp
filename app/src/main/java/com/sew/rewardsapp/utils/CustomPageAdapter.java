package com.sew.rewardsapp.utils;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.progresviews.ProgressWheel;
import com.race604.drawable.wave.WaveDrawable;
import com.sew.rewardsapp.R;
import com.sew.rewardsapp.enums.ModelObject;

/**
 * Created by siddharthkumar on 19/1/18.
 */

public class CustomPageAdapter extends PagerAdapter{
    private Context mContext;

    public CustomPageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        Integer usage = 70;
        Typeface tfArial = Typeface.createFromAsset(mContext.getAssets(), "arial.ttf");


        switch(position) {
            case 0:
                ImageView mImageView = (ImageView) layout.findViewById(R.id.image);
                WaveDrawable mWaveDrawable = new WaveDrawable(mContext, R.drawable.glass1);
                mImageView.setImageDrawable(mWaveDrawable);
                Integer level = 4000;
                Integer ampl = 7;
                Integer length = 200;
                Integer speed = 3;

                mWaveDrawable.setLevel(level);
                mWaveDrawable.setWaveAmplitude(ampl);
                mWaveDrawable.setWaveLength(length);
                mWaveDrawable.setWaveSpeed(speed);

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
                valueAnimator.setRepeatMode(ValueAnimator.RESTART);
                valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator.setDuration(5000);
                mWaveDrawable.setIndeterminateAnimator(valueAnimator);
                mWaveDrawable.setIndeterminate(true);
                TextView mTextView = (TextView) layout.findViewById(R.id.water_wave_amt);
                mTextView.setTypeface(tfArial);
                mTextView.setText(usage.toString() + " L");
                Button mButtonView = (Button) layout.findViewById(R.id.button);
                mButtonView.setTypeface(tfArial);
                break;
            case 1:
                ProgressWheel progressWheel = (ProgressWheel) layout.findViewById(R.id.wheelprogress);
                progressWheel.setPercentage(150);
                progressWheel.setStepCountText("150");
                progressWheel.setDefText("Litres saved");
                break;
            case 2:
                TextView textView1 = (TextView) layout.findViewById(R.id.point_counter);
                textView1.setText(usage.toString());
                Button mButtonView1 = (Button) layout.findViewById(R.id.button1);
                mButtonView1.setTypeface(tfArial);
                break;
        }

        collection.addView(layout);

        return layout;
    }



    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return ModelObject.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject customPageEnum = ModelObject.values()[position];
        return mContext.getString(customPageEnum.getTitleResId());
    }

}
