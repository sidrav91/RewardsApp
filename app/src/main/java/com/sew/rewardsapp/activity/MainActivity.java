package com.sew.rewardsapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.utils.CustomPageAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPageAdapter(this));
    }



    public void redeem(View view){
        Intent homeIntent = new Intent(this, MyActivityGrid.class);
        startActivity(homeIntent);
    }
}
