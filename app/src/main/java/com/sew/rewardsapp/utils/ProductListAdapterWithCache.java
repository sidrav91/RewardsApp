package com.sew.rewardsapp.utils;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.activity.ItemViewActivity;
import com.sew.rewardsapp.pojo.RewardItem;

import java.util.List;

/**
 * Created by siddharthkumar on 23/1/18.
 */

public class ProductListAdapterWithCache extends ArrayAdapter<RewardItem> {
    private Context mContext;
    private List<RewardItem> mylist;

    public ProductListAdapterWithCache(Context _context, List<RewardItem> _mylist) {
        super(_context, R.layout.item_display, _mylist);

        mContext = _context;
        this.mylist = _mylist;

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final RewardItem product = getItem(position);

        ProductViewHolder holder;

        if (convertView == null) {
            convertView = new LinearLayout(getContext());

            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
            convertView = vi.inflate(R.layout.item_display, parent, false);

            //
            holder = new ProductViewHolder();
            holder.img = (ImageView)convertView.findViewById(R.id.item_image);
            holder.title = (TextView)convertView.findViewById(R.id.reward_item_title);
            holder.price = (TextView)convertView.findViewById(R.id.reward_item_price);

            //
            convertView.setTag(holder);

        }
        else{
            holder = (ProductViewHolder) convertView.getTag();
        }


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ItemViewActivity.class);
                intent.putExtra("product", product);
                getContext().startActivity(intent);
            }
        });

        holder.populate(product);

        return convertView;
    }




    static class ProductViewHolder {
        public ImageView img;
        public TextView title;
        public TextView price;

        void populate(RewardItem p) {
            title.setText(p.getName());
            price.setText("$"+p.getPrice().toString());
            img.setImageResource(p.getImageResource());
        }
    }

}
