package com.sew.rewardsapp.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.ItemType;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.ProductListAdapterWithCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddharthkumar on 23/1/18.
 */

public class MyActivityGrid extends AppCompatActivity implements AbsListView.OnScrollListener {
    List<RewardItem> products = new ArrayList<RewardItem>();
    GridView gvProducts = null;
    ProductListAdapterWithCache adapterProducts;


    private boolean lvBusy = false;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_grid);

        RewardItem item1 = new RewardItem("Bosch Front Load", new Double(700), ItemType.WASHING_MACHINE, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item2 = new RewardItem("Village Movie Voucher", new Double(100), ItemType.MOVIE_TICKET, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item3 = new RewardItem("2.5KL Slimline Tank", new Double(1650), ItemType.TANK, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item4 = new RewardItem("Bosch showerhead", new Double(80), ItemType.SHOWER_HEAD, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item5 = new RewardItem("Simmens Taps", new Double(70), ItemType.TAP, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item1);
        products.add(item2);
        products.add(item3);
        products.add(item4);
        products.add(item5);

        //
        gvProducts = (GridView) findViewById(R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(this, products);
        gvProducts.setAdapter(adapterProducts);

        Typeface tfOswald = Typeface.createFromAsset(getAssets(), "oswald.ttf");
        Button button = (Button) findViewById(R.id.list_all_btn);
        button.setTypeface(tfOswald);
        button = (Button) findViewById(R.id.list_bathroom_btn);
        button.setTypeface(tfOswald);
        button = (Button) findViewById(R.id.list_garden_btn);
        button.setTypeface(tfOswald);
        button = (Button) findViewById(R.id.list_kitchen_btn);
        button.setTypeface(tfOswald);
        button = (Button) findViewById(R.id.list_laundry_btn);
        button.setTypeface(tfOswald);
        button = (Button) findViewById(R.id.list_fun_btn);
        button.setTypeface(tfOswald);
        button = (Button) findViewById(R.id.list_other_btn);
        button.setTypeface(tfOswald);
        TextView textView = (TextView) findViewById(R.id.list_balance_text);
        textView.setTypeface(tfOswald);
        textView.setText("$673");

    }

    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState) {
            case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                lvBusy = false;
                adapterProducts.notifyDataSetChanged();
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                lvBusy = true;
                break;
            case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                lvBusy = true;
                break;
        }
    }


    public boolean isLvBusy() {
        return lvBusy;
    }

}