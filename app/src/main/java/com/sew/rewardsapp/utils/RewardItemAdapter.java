package com.sew.rewardsapp.utils;

import com.ahamed.multiviewadapter.BaseViewHolder;
import com.ahamed.multiviewadapter.DataListManager;
import com.ahamed.multiviewadapter.RecyclerAdapter;
import com.sew.rewardsapp.pojo.RewardItem;

import java.util.List;

/**
 * Created by siddharthkumar on 23/1/18.
 */

public class RewardItemAdapter extends RecyclerAdapter{

    private DataListManager<RewardItem> dataManager;

    public RewardItemAdapter(BaseViewHolder.OnItemClickListener<RewardItem> onItemClickListener) {
        this.dataManager = new DataListManager<RewardItem>(this);
        addDataManager(dataManager);
        registerBinder(new RewardItemBinder(onItemClickListener));
    }

    public void setDataList(List<RewardItem> dataList) {
        dataManager.addAll(dataList);
    }
}
