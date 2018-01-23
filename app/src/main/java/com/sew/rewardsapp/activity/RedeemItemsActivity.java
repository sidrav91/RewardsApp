package com.sew.rewardsapp.activity;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.ahamed.multiviewadapter.BaseViewHolder;
import com.ahamed.multiviewadapter.ItemViewHolder;
import com.ahamed.multiviewadapter.SimpleRecyclerAdapter;
import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.RewardItem;
import com.sew.rewardsapp.utils.RewardItemAdapter;
import com.sew.rewardsapp.utils.RewardItemBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by siddharthkumar on 22/1/18.
 */

public class RedeemItemsActivity extends Activity {

    private RecyclerView recyclerView;
    private List<RewardItem> rewardItems;


    /*protected void setUpAdapter() {
        RewardItemAdapter rewardItemAdapter = new RewardItemAdapter(new BaseViewHolder.OnItemClickListener<RewardItem>(){

            public void onItemClick(View view, String item) {
                //goToNextActivity(data)
            }
        });
    }*/

    public void initViews() {
        RewardItemAdapter adapter = new RewardItemAdapter(new ItemViewHolder.OnItemClickListener<RewardItem>() {
            @Override
            public void onItemClick(View view, RewardItem item) {

            }
        });
        recyclerView.setAdapter(adapter);
        adapter.setDataList(populateData());
    }

    public List<RewardItem> populateData() {
        List<RewardItem> rewardItems = new ArrayList<RewardItem>();

        /*RewardItem item1 = new RewardItem("Boch Front Load", new Double(700), R.mipmap.ic_launcher);
        RewardItem item2 = new RewardItem("Boch Front Load1", new Double(300), R.mipmap.ic_launcher);
        RewardItem item3 = new RewardItem("Boch Front Load2", new Double(400), R.mipmap.ic_launcher);
        RewardItem item4 = new RewardItem("Boch Front Load3", new Double(500), R.mipmap.ic_launcher);
        RewardItem item5 = new RewardItem("Boch Front Load4", new Double(600), R.mipmap.ic_launcher);

        rewardItems.add(item1);
        rewardItems.add(item2);
        rewardItems.add(item3);
        rewardItems.add(item4);
        rewardItems.add(item5);*/

        return rewardItems;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.item_list);

        *//*recyclerView = (RecyclerView) findViewById(R.id.rcv_list);

        RewardItemAdapter rewardItemAdapter = new RewardItemAdapter(new BaseViewHolder.OnItemClickListener<RewardItem>(){
            @Override
            public void onItemClick(View view, RewardItem rewardItem) {
                RedeemItemsActivity.start(this);
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(rewardItemAdapter);


        rewardItemAdapter.setDataList(populateData());*//*


        RelativeLayout rl = (RelativeLayout) findViewById(R.id.item_list);

        ScrollView sv = new ScrollView(this);
        sv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        LinearLayout ll = new LinearLayout(this);
        ll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);
        for(final RewardItem item : populateData()) {
            LinearLayout lin = new LinearLayout(this);
            lin.setOrientation(LinearLayout.VERTICAL);

            final ImageView img = new ImageView(this);
            //img.setImageResource(item.getImageName());
            img.setLayoutParams(new LayoutParams(220, 200));
            lin.addView(img);

            TextView product = new TextView(this);
            product.setText(item.getName());
            product.setTextSize(24);
            product.setTypeface(Typeface.createFromAsset(getAssets(), "abel.ttf"));
            lin.addView(product);

            TextView price = new TextView(this);
            price.setText("$" + item.getPrice());
            price.setTextSize(24);
            price.setTypeface(Typeface.createFromAsset(getAssets(), "abel.ttf"), Typeface.BOLD);
            lin.addView(price);

            lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "clicked " + item.getName(), Toast.LENGTH_LONG).show();
                }
            });
            ll.addView(lin);

        }
        rl.addView(sv);*/





    }


}
