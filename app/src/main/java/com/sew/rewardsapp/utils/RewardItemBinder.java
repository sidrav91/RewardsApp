package com.sew.rewardsapp.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahamed.multiviewadapter.BaseViewHolder;
import com.ahamed.multiviewadapter.ItemBinder;
import com.sew.rewardsapp.R;
import com.sew.rewardsapp.pojo.RewardItem;

/**
 * Created by siddharthkumar on 23/1/18.
 */

public class RewardItemBinder extends ItemBinder<RewardItem, RewardItemBinder.ItemViewHolder> {

    private final BaseViewHolder.OnItemClickListener<RewardItem> onItemClickListener;

    RewardItemBinder(BaseViewHolder.OnItemClickListener<RewardItem> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ItemViewHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new ItemViewHolder(inflater.inflate(R.layout.item_display, parent, false), onItemClickListener);
    }

    @Override
    public void bind(ItemViewHolder holder, RewardItem item) {
        holder.caption.setText(item.getName());
        holder.price.setText(item.getPrice().toString());
        holder.ivIndicator.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public boolean canBindData(Object item) {
        return item instanceof RewardItem;
    }

    static class ItemViewHolder extends BaseViewHolder<RewardItem> {

        private TextView caption;
        private TextView price;
        private ImageView ivIndicator;

        public ItemViewHolder(View itemView, OnItemClickListener<RewardItem> onItemClickListener) {
            super(itemView);
            caption = (TextView) itemView.findViewById(R.id.reward_item_title);
            price = (TextView) itemView.findViewById(R.id.reward_item_price);
            ivIndicator = (ImageView) itemView.findViewById(R.id.item_image);
            setItemClickListener(onItemClickListener);
        }
    }
}
