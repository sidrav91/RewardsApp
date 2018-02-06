package com.sew.rewardsapp.fragment;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.CartItem;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.MyData;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class ItemViewFragment extends Fragment{

    RewardItem rewardItem;
    int pointUsed;
    int buyingPrice;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        rewardItem = MyData.buffer;
        View rootView = inflater.inflate(R.layout.activity_item_view, container, false);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Typeface tfAbel = Typeface.createFromAsset(getActivity().getAssets(), "abel.ttf");
        TextView textView1= (TextView) getActivity().findViewById(R.id.toolbar_title);
        textView1.setText("Redeem");
        textView1.setTypeface(tfAbel);


        TextView title = getActivity().findViewById(R.id.item_title);
        title.setText(rewardItem.getName());
        title.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf"));

        ExpandableTextView expTv1 = (ExpandableTextView) view.findViewById(R.id.sample1)
                .findViewById(R.id.expand_text_view);
        expTv1.setText(rewardItem.getDescription());
        //expTv1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf"));


        /*ExpandableTextView desc = (ExpandableTextView) getActivity().findViewById(R.id.expandable_text);
        desc.setText(rewardItem.getDescription());*/
        //desc.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf"));

        ImageView img = getActivity().findViewById(R.id.item_img);
        img.setImageResource(rewardItem.getImageResource());

        TextView balance = getActivity().findViewById(R.id.item_balance_text);
        balance.setText("$" + MyData.balance);
        balance.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "oswald.ttf"));


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
        int intBalance = MyData.balance;
        final int maxDiscountedPrice = maxDiscount < intBalance ? itemPrice-maxDiscount : itemPrice-intBalance;
        TextView finalCostText = getActivity().findViewById(R.id.discounted_price);
        finalCostText.setText("$"+maxDiscountedPrice);

        SeekBar seekBar = getActivity().findViewById(R.id.seekBar);
        seekBar.setMax(maxDiscount < intBalance ? maxDiscount : intBalance);

        TextView discountedPriceText = getActivity().findViewById(R.id.item_price);
        pointUsed = seekBar.getProgress();
        buyingPrice = itemPrice - seekBar.getProgress();
        discountedPriceText.setText("$"+(itemPrice- pointUsed));


        TextView itemPriceText = getActivity().findViewById(R.id.final_cost);
        itemPriceText.setText("$"+(itemPrice- pointUsed));

        TextView pointsUsedText = getActivity().findViewById(R.id.points_used);
        pointsUsedText.setText("+"+ pointUsed +"Pts");



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                TextView discountedPriceText = getActivity().findViewById(R.id.item_price);
                TextView finalCostText = getActivity().findViewById(R.id.discounted_price);
                TextView pointsUsedText = getActivity().findViewById(R.id.points_used);
                pointsUsedText.setText("+"+(seekBar.getProgress())+"Pts");
                TextView itemPriceText = getActivity().findViewById(R.id.final_cost);
                buyingPrice = itemPrice - seekBar.getProgress();
                pointUsed = seekBar.getProgress();
                itemPriceText.setText("$"+ buyingPrice);
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


        TextView textView = getActivity().findViewById(R.id.textView2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyData.cartItems.add(new CartItem(rewardItem.getName(), new Double(buyingPrice), rewardItem.getImageResource(), pointUsed));
                MyData.balance=MyData.balance-pointUsed;
                Fragment fragment = new OrdersFragment();
                if (fragment != null) {
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment).addToBackStack(null);
                    ft.commit();
                    ft.addToBackStack(null);
                }

            /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);*/
            }
        });

        seekBar.setProgress(seekBar.getMax());



    }





}
