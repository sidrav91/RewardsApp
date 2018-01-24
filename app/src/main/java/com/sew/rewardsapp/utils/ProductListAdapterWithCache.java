package com.sew.rewardsapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.activity.MyActivityGrid;
import com.sew.rewardsapp.pojo.ItemType;
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
        RewardItem product = getItem(position);

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


        //
        holder.populate(product, ((MyActivityGrid)mContext).isLvBusy());

        //
        return convertView;
    }




    static class ProductViewHolder {
        public ImageView img;
        public TextView title;
        public TextView price;

        void populate(RewardItem p, boolean isBusy) {
            title.setText(p.getName());
            price.setText("$"+p.getPrice().toString());
            setImageBasedOnType(p.getItemType(), img);
        }

        private void setImageBasedOnType(ItemType itemType, ImageView imageView) {
            switch (itemType) {
                case WASHING_MACHINE:
                    imageView.setImageResource(R.mipmap.wash);
                    break;
                case TAP:
                    imageView.setImageResource(R.mipmap.taps);
                    break;
                case TANK:
                    imageView.setImageResource(R.mipmap.tank);
                    break;
                case FRIDGE:
                    imageView.setImageResource(R.mipmap.fridge);
                    break;
                case MOVIE_TICKET:
                    imageView.setImageResource(R.mipmap.cinema);
                    break;
                case SHOWER_HEAD:
                    imageView.setImageResource(R.mipmap.shower);
                    break;
            }
        }
    }

}
