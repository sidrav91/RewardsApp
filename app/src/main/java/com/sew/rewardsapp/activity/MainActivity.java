package com.sew.rewardsapp.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.race604.drawable.wave.WaveDrawable;
import com.sew.rewardsapp.R;
import com.sew.rewardsapp.utils.CustomPageAdapter;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;
    private WaveDrawable mWaveDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPageAdapter(this));

        //animateGlass();
        //animateProgressBar(70);

    }

    private void animateGlass() {
        mImageView = (ImageView) findViewById(R.id.image);
        mWaveDrawable = new WaveDrawable(this, R.drawable.glass1);
        mImageView.setImageDrawable(mWaveDrawable);
        Integer perc = 70;
        Integer level = perc/100*8036;
        Integer ampl = 19;
        Integer length = 196;
        Integer speed = 6;
        mWaveDrawable.setLevel(4000);
        mWaveDrawable.setWaveAmplitude(ampl);
        mWaveDrawable.setWaveLength(length);
        mWaveDrawable.setWaveSpeed(speed);
        /*ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.);
        animator.setDuration(4000);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        mWaveDrawable.setIndeterminateAnimator(animator);*/
        mWaveDrawable.setIndeterminate(false);
    }

    /*private void animateProgressBar(Integer usage) {
        TextView textView = (TextView) findViewById(R.id.progressText);
        textView.setText(usage.toString() + "%");
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.graph);
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, usage);
        animation.setDuration(2000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }*/
}
