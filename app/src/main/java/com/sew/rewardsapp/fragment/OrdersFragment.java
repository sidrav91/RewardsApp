package com.sew.rewardsapp.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.CartItem;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.CartListAdapter;
import com.sew.rewardsapp.utils.MyData;
import com.sew.rewardsapp.utils.ProductListAdapterWithCache;
import com.sew.rewardsapp.utils.RecyclerItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddharthkumar on 3/1/18.
 */

public class OrdersFragment extends Fragment implements View.OnClickListener, RecyclerItemTouchHelper.RecyclerItemTouchHelperListener {

    GridView gvProducts = null;
    ProductListAdapterWithCache adapterProducts;
    Typeface arial;
    private RecyclerView recyclerView;
    private List<CartItem> cartList;
    private CartListAdapter mAdapter;
    private CoordinatorLayout coordinatorLayout;
    Double total;
    Double total_wo_disc = new Double(0);
    Integer pointsUsed = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return inflater.inflate(R.layout.fragment_orders, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Shopping Cart");
        setOnClickListenersForButtons(view);
        arial = Typeface.createFromAsset(getActivity().getAssets(), "arial.ttf");
        resetAllButtons(view);

        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different title
        getActivity().setTitle("Shopping Cart");

        total = new Double(0);
        for(CartItem cartItem : MyData.cartItems){
            total_wo_disc += cartItem.getPurchasePrice() + cartItem.getPointsUsed();
            total += cartItem.getPurchasePrice();
            pointsUsed += cartItem.getPointsUsed();
        }

        computeTotals();

        TextView payable = getActivity().findViewById(R.id.textView6);
        payable.setText("$"+total);

        recyclerView = getActivity().findViewById(R.id.recycler_view);
        coordinatorLayout = getActivity().findViewById(R.id.coordinator_layout);
        cartList = new ArrayList<>();
        mAdapter = new CartListAdapter(getActivity().getApplicationContext(), cartList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        // adding item touch helper
        // only ItemTouchHelper.LEFT added to detect Right to Left swipe
        // if you want both Right -> Left and Left -> Right
        // add pass ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT as param
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);


        // making http call and fetching menu json
        prepareCart();


    }

    private void computeTotals() {
        MyData.subtotal = MyData.toInt(total_wo_disc);
        MyData.point_used = pointsUsed;
        MyData.total = MyData.subtotal - MyData.point_used + MyData.shipping;
    }

    private void prepareCart() {
        cartList.clear();
        cartList.addAll(MyData.cartItems);

        // refreshing recycler view
        mAdapter.notifyDataSetChanged();
    }

    private void resetAllButtons(View view) {
        Button button = (Button) getView().findViewById(R.id.orders_products);
        int color = view.getResources().getColor(R.color.colorGrey);
        button.setBackgroundColor(color);
        button.setTextColor(view.getResources().getColor(R.color.colorLight));
        button.setTypeface(arial);
        button.setAllCaps(false);
        button = (Button) getView().findViewById(R.id.orders_address);
        button.setBackgroundColor(color);
        button.setAllCaps(false);
        button.setTextColor(view.getResources().getColor(R.color.colorWhite));
        button.setTypeface(arial);
        button = (Button) getView().findViewById(R.id.orders_payment);
        button.setBackgroundColor(color);
        button.setAllCaps(false);
        button.setTextColor(view.getResources().getColor(R.color.colorWhite));
        button.setTypeface(arial);
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
                return;
            case R.id.orders_address:
                fragment = new AddressFragment();
                break;
            case R.id.orders_payment:
                fragment = new PaymentFragment();
                break;
            case R.id.continue_btn:
                fragment = new AddressFragment();
                break;
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

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof CartListAdapter.MyViewHolder) {
            // get the removed item name to display it in snack bar
            String name = cartList.get(viewHolder.getAdapterPosition()).getName();

            // backup of removed item for undo purpose
            final CartItem deletedItem = cartList.get(viewHolder.getAdapterPosition());
            total -= deletedItem.getPurchasePrice();
            total_wo_disc -= deletedItem.getPurchasePrice() + deletedItem.getPointsUsed();
            TextView payable = getActivity().findViewById(R.id.textView6);
            payable.setText("$"+total);
            MyData.balance+=deletedItem.getPointsUsed();
            MyData.cartItems.remove(deletedItem);
            computeTotals();
            final int deletedIndex = viewHolder.getAdapterPosition();

            // remove the item from recycler view
            mAdapter.removeItem(viewHolder.getAdapterPosition());

            // showing snack bar with Undo option
            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, name + " removed from cart!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // undo is selected, restore the deleted item
                    mAdapter.restoreItem(deletedItem, deletedIndex);
                    total += deletedItem.getPurchasePrice();
                    MyData.balance-=deletedItem.getPointsUsed();
                    MyData.cartItems.add(deletedItem);
                    TextView payable = getActivity().findViewById(R.id.textView6);
                    payable.setText("$"+total);
                    computeTotals();
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }
}
