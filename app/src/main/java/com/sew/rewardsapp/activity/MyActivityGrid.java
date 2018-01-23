package com.sew.rewardsapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.GridView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.ProductListAdapterWithCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddharthkumar on 23/1/18.
 */

public class MyActivityGrid extends Activity implements AbsListView.OnScrollListener {
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

        RewardItem item1 = new RewardItem("Boch Front Load", new Double(700), "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item2 = new RewardItem("Boch Front Load1", new Double(300), "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item3 = new RewardItem("Boch Front Load2", new Double(400), "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item4 = new RewardItem("Boch Front Load3", new Double(500), "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item5 = new RewardItem("Boch Front Load4", new Double(600), "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item1);
        products.add(item2);
        products.add(item3);
        products.add(item4);
        products.add(item5);

        //
        gvProducts = (GridView) findViewById(R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(this, products);
        gvProducts.setAdapter(adapterProducts);

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