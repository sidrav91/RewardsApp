package com.sew.rewardsapp.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.MyData;

public class ItemViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        Bundle data = getIntent().getExtras();
        RewardItem rewardItem = data.getParcelable("product");

        TextView title = findViewById(R.id.item_title);
        title.setText(rewardItem.getName());
        title.setTypeface(Typeface.createFromAsset(getAssets(), "arial.ttf"));

        TextView desc = findViewById(R.id.item_desc);
        desc.setText(rewardItem.getDescription());
        desc.setTypeface(Typeface.createFromAsset(getAssets(), "arial.ttf"));

        ImageView img = findViewById(R.id.item_img);
        img.setImageResource(rewardItem.getImageResource());

        TextView balance = findViewById(R.id.item_balance_text);
        balance.setText("$" + MyData.balance);
        balance.setTypeface(Typeface.createFromAsset(getAssets(), "oswald.ttf"));


        /*final int itemPrice = MyData.toInt(rewardItem.getPrice());
        int maxDiscount = MyData.toInt(rewardItem.getMaxDiscount());
        int intBalance = MyData.toInt(MyData.balance);
        final int maxDiscountedPrice = maxDiscount < intBalance ? itemPrice-maxDiscount : itemPrice-intBalance;

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(itemPrice);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if(progress < maxDiscountedPrice) {
                    seekBar.setProgress(maxDiscountedPrice);
                }
                TextView discountedPriceText = findViewById(R.id.discounted_price);
                discountedPriceText.setText("$"+seekBar.getProgress());
                TextView finalCostText = findViewById(R.id.final_cost);
                finalCostText.setText("$"+seekBar.getProgress());
                TextView pointsUsedText = findViewById(R.id.points_used);
                pointsUsedText.setText("+"+(itemPrice-seekBar.getProgress())+"Pts");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        TextView itemPriceText = findViewById(R.id.item_price);
        itemPriceText.setText("$" + itemPrice);*/

        final int itemPrice = MyData.toInt(rewardItem.getPrice());
        int maxDiscount = MyData.toInt(rewardItem.getMaxDiscount());
        int intBalance = MyData.toInt(MyData.balance);
        final int maxDiscountedPrice = maxDiscount < intBalance ? itemPrice-maxDiscount : itemPrice-intBalance;
        TextView finalCostText = findViewById(R.id.discounted_price);
        finalCostText.setText("$"+maxDiscountedPrice);

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(maxDiscount < intBalance ? maxDiscount : intBalance);

        TextView discountedPriceText = findViewById(R.id.item_price);
        discountedPriceText.setText("$"+(itemPrice-seekBar.getProgress()));


        TextView itemPriceText = findViewById(R.id.final_cost);
        itemPriceText.setText("$"+(itemPrice-seekBar.getProgress()));

        TextView pointsUsedText = findViewById(R.id.points_used);
        pointsUsedText.setText("+"+(seekBar.getProgress())+"Pts");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                TextView discountedPriceText = findViewById(R.id.item_price);
                TextView finalCostText = findViewById(R.id.discounted_price);
                TextView pointsUsedText = findViewById(R.id.points_used);
                pointsUsedText.setText("+"+(seekBar.getProgress())+"Pts");
                TextView itemPriceText = findViewById(R.id.final_cost);
                itemPriceText.setText("$"+(itemPrice-seekBar.getProgress()));
                if(progress!=0){
                    discountedPriceText.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                } else {
                    discountedPriceText.setPaintFlags(finalCostText.getPaintFlags());
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
