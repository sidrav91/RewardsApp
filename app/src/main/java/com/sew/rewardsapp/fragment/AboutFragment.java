package com.sew.rewardsapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sew.rewardsapp.R;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class AboutFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_about, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        Typeface tfAbel = Typeface.createFromAsset(getActivity().getAssets(), "abel.ttf");
        TextView textView1= (TextView) getActivity().findViewById(R.id.toolbar_title);
        textView1.setText("About");
        textView1.setTypeface(tfAbel);

        Typeface tfOswald = Typeface.createFromAsset(getActivity().getAssets(), "oswald.ttf");
        TextView text = (TextView) getView().findViewById(R.id.about_caption);
        text.setTypeface(tfOswald);


        text = (TextView) getView().findViewById(R.id.about_part1);
        text.setTypeface(tfAbel);


        text = (TextView) getView().findViewById(R.id.about_part2);
        text.setTypeface(tfAbel);


    }

}
