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
import com.sew.rewardsapp.pojo.CartItem;
import com.sew.rewardsapp.utils.MyData;

import java.util.ArrayList;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class OrderConfirmFragment extends Fragment implements View.OnClickListener {

    Typeface arial;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_order_confirm, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Confirmation");
        setOnClickListenersForButtons(view);
        arial = Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf");


        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different title
        getActivity().setTitle("Checkout");
        MyData.cartItems = new ArrayList<CartItem>();
    }

    private void setOnClickListenersForButtons(View view) {
        TextView textView = getView().findViewById(R.id.continue_btn);
        textView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        //creating fragment object
        Fragment fragment = new HomeFragment();
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
