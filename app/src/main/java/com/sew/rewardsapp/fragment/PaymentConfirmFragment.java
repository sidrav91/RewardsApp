package com.sew.rewardsapp.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.utils.MyData;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class PaymentConfirmFragment extends Fragment implements View.OnClickListener {

    Typeface arial;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_payment_confirm, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Checkout");

        setOnClickListenersForButtons(view);
        arial = Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf");
        resetAllButtons(view);




        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different title
        getActivity().setTitle("Checkout");

        TextView textView = getActivity().findViewById(R.id.subtotal_text);
        textView.setText("$"+MyData.subtotal);
        textView = getActivity().findViewById(R.id.points_text);
        textView.setText("$"+MyData.point_used);
        textView = getActivity().findViewById(R.id.shipping_text);
        textView.setText("$"+MyData.shipping);
        textView = getActivity().findViewById(R.id.total_text);
        textView.setText("$"+MyData.total);
    }

    private void resetAllButtons(View view) {
        Button button = (Button) getView().findViewById(R.id.orders_products);
        int color = view.getResources().getColor(R.color.colorGrey);
        button.setBackgroundColor(color);
        button.setTextColor(view.getResources().getColor(R.color.colorWhite));
        button.setTypeface(arial);
        button.setAllCaps(false);
        button = (Button) getView().findViewById(R.id.orders_address);
        button.setBackgroundColor(color);
        button.setTextColor(view.getResources().getColor(R.color.colorWhite));
        button.setTypeface(arial);
        button.setAllCaps(false);
        button = (Button) getView().findViewById(R.id.orders_payment);
        button.setBackgroundColor(color);
        button.setTextColor(view.getResources().getColor(R.color.colorLight));
        button.setTypeface(arial);
        button.setAllCaps(false);
    }

    private void setOnClickListenersForButtons(View view) {
        Button button = (Button) getView().findViewById(R.id.orders_products);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.orders_address);
        button.setOnClickListener(this);
        button = (Button) getView().findViewById(R.id.orders_payment);
        button.setOnClickListener(this);
        TextView textView = getView().findViewById(R.id.continue_btn);
        textView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        resetAllButtons(view);

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (view.getId()) {
            case R.id.orders_products:
                fragment = new OrdersFragment();
                break;
            case R.id.orders_address:
                fragment = new AddressFragment();
                break;
            case R.id.continue_btn:
                fragment = new OrderConfirmFragment();
                break;
            case R.id.orders_payment:
                return;
        }
        replaceFragment(fragment);

    }

    private void replaceFragment(Fragment fragment) {
        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

}
