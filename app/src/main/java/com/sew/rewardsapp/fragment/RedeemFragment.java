package com.sew.rewardsapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.MyData;
import com.sew.rewardsapp.utils.ProductListAdapterWithCache;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class RedeemFragment extends Fragment implements AbsListView.OnScrollListener, View.OnClickListener {


    GridView gvProducts = null;
    ProductListAdapterWithCache adapterProducts;
    Typeface tfOswald;



    private boolean lvBusy = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_grid, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        /*Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Redeem");*/
        TextView textView1= (TextView) getActivity().findViewById(R.id.toolbar_title);
        textView1.setText("Redeem");
        textView1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "abel.ttf"));
        setOnClickListenersForButtons(view);
        tfOswald = Typeface.createFromAsset(getActivity().getAssets(), "oswald.ttf");
        changeTabToAll(view);
        TextView textView = (TextView) getView().findViewById(R.id.list_balance_text);
        textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "oswald.ttf"));
        textView.setText("$"+MyData.balance);

        SearchView searchView = getActivity().findViewById(R.id.searchView);
        searchView.getBackground().setAlpha(64);


        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different title
        getActivity().setTitle("Redeem");
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


    public void changeTabToAll(View view) {
        resetAllButtons(view);
        Button button = (Button) getView().findViewById(R.id.list_all_btn);
        button.setBackgroundColor(view.getResources().getColor(R.color.colorLightGrey));
        button.getBackground().setAlpha(64);
        button.setTypeface(tfOswald);

        //
        gvProducts = (GridView) getView().findViewById(R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(getContext(), MyData.items);
        gvProducts.setAdapter(adapterProducts);
    }

    private void resetAllButtons(View view) {
        Button button = (Button) getView().findViewById(R.id.list_all_btn);
        int color = view.getResources().getColor(R.color.colorGrey);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
        button = (Button) getView().findViewById(R.id.list_bathroom_btn);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
        button = (Button) getView().findViewById(R.id.list_garden_btn);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
        button = (Button) getView().findViewById(R.id.list_kitchen_btn);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
        button = (Button) getView().findViewById(R.id.list_other_btn);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
        button = (Button) getView().findViewById(R.id.list_fun_btn);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
        button = (Button) getView().findViewById(R.id.list_laundry_btn);
        button.setBackgroundColor(color);
        button.setTypeface(tfOswald);
    }

    private void setOnClickListenersForButtons(View view) {
        Button button = (Button) getView().findViewById(R.id.list_all_btn);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.list_bathroom_btn);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.list_garden_btn);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.list_kitchen_btn);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.list_other_btn);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.list_fun_btn);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.list_laundry_btn);
        button.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        resetAllButtons(view);

        Button button = (Button) getView().findViewById(view.getId());
        button.setBackgroundColor(view.getResources().getColor(R.color.colorLightGrey));
        button.getBackground().setAlpha(64);
        button.setTypeface(tfOswald);

        List<RewardItem> products = new ArrayList<RewardItem>();

        switch(view.getId()) {
            case R.id.list_all_btn:
                products = MyData.items;
                break;
            case R.id.list_bathroom_btn:
                products = MyData.bathItems;
                break;
            case R.id.list_kitchen_btn:
                products = MyData.kitchenItems;
                break;
            case R.id.list_laundry_btn:
                products = MyData.laundryItems;
                break;
            case R.id.list_garden_btn:
                products = MyData.gardenItems;
                break;
            case R.id.list_other_btn:
                products = MyData.otherItems;
                break;
            case R.id.list_fun_btn:
                products = MyData.funItems;
                break;
        }

        gvProducts = (GridView) getView().findViewById(R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(getContext(), products);
        gvProducts.setAdapter(adapterProducts);
    }
}
