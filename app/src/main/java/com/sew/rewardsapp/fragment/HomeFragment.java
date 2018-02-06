package com.sew.rewardsapp.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.race604.drawable.wave.WaveDrawable;
import com.sew.rewardsapp.R;
import com.sew.rewardsapp.utils.CustomPageAdapter;
import com.sew.rewardsapp.utils.MyData;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class HomeFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments

        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Typeface tfAbel = Typeface.createFromAsset(getActivity().getAssets(), "abel.ttf");
        TextView textView1= (TextView) getActivity().findViewById(R.id.toolbar_title);
        textView1.setText("");
        textView1.setTypeface(tfAbel);
        ViewPager viewPager = (ViewPager) getView().findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPageAdapter(getContext()));
        super.onViewCreated(view, savedInstanceState);
    }



}
