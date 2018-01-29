package com.sew.rewardsapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.ItemType;
import com.sew.rewardsapp.pojo.RewardItem;
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
        setOnClickListenersForButtons(view);
        tfOswald = Typeface.createFromAsset(getActivity().getAssets(), "oswald.ttf");
        changeTabToAll(view);
        TextView textView = (TextView) getView().findViewById(R.id.list_balance_text);
        textView.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), "oswald.ttf"));
        textView.setText("$673");

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
        button.setTypeface(tfOswald);

        //
        gvProducts = (GridView) getView().findViewById(R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(getContext(), getAllProducts());
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
        button.setTypeface(tfOswald);

        List<RewardItem> products = new ArrayList<RewardItem>();

        switch(view.getId()) {
            case R.id.list_all_btn:
                products = getAllProducts();
                break;
            case R.id.list_bathroom_btn:
                products = getBathroomProducts();
                break;
            case R.id.list_kitchen_btn:
                products = getKitchenProducts();
                break;
            case R.id.list_laundry_btn:
                products = getLaundryProducts();
                break;
            case R.id.list_garden_btn:
                products = getGardenProducts();
                break;
            case R.id.list_other_btn:
                products = getOtherProducts();
                break;
            case R.id.list_fun_btn:
                products = getFunProducts();
                break;
        }

        gvProducts = (GridView) getView().findViewById(R.id.grid_products);
        adapterProducts = new ProductListAdapterWithCache(getContext(), products);
        gvProducts.setAdapter(adapterProducts);
    }

    @NonNull
    private List<RewardItem> getAllProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
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
        return products;
    }

    @NonNull
    private List<RewardItem> getBathroomProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
        RewardItem item4 = new RewardItem("Bosch showerhead", new Double(80), ItemType.SHOWER_HEAD, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item5 = new RewardItem("Simmens Taps", new Double(70), ItemType.TAP, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item4);
        products.add(item5);
        return products;
    }

    @NonNull
    private List<RewardItem> getKitchenProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
        RewardItem item5 = new RewardItem("Simmens Taps", new Double(70), ItemType.TAP, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item5);
        return products;
    }

    @NonNull
    private List<RewardItem> getGardenProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
        RewardItem item3 = new RewardItem("2.5KL Slimline Tank", new Double(1650), ItemType.TANK, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item3);
        return products;
    }

    @NonNull
    private List<RewardItem> getLaundryProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
        RewardItem item1 = new RewardItem("Bosch Front Load", new Double(700), ItemType.WASHING_MACHINE, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item1);
        return products;
    }

    @NonNull
    private List<RewardItem> getOtherProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
        RewardItem item3 = new RewardItem("2.5KL Slimline Tank", new Double(1650), ItemType.TANK, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");
        RewardItem item4 = new RewardItem("Bosch showerhead", new Double(80), ItemType.SHOWER_HEAD, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item3);
        products.add(item4);
        return products;
    }

    @NonNull
    private List<RewardItem> getFunProducts() {
        List<RewardItem> products = new ArrayList<RewardItem>();
        RewardItem item2 = new RewardItem("Village Movie Voucher", new Double(100), ItemType.MOVIE_TICKET, "http://farm5.staticflickr.com/4142/4787427683_3672f1db9a_s.jpg");

        products.add(item2);
        return products;
    }
}
