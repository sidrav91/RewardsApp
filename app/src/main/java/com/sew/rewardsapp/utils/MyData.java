package com.sew.rewardsapp.utils;

import com.sew.rewardsapp.R;
import com.sew.rewardsapp.enums.Category;
import com.sew.rewardsapp.pojo.CartItem;
import com.sew.rewardsapp.pojo.ItemType;
import com.sew.rewardsapp.pojo.RewardItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by siddharthkumar on 30/1/18.
 */

public class MyData {

    public static List<RewardItem> items = new ArrayList<RewardItem>();
    public static List<RewardItem> bathItems = new ArrayList<RewardItem>();
    public static List<RewardItem> gardenItems = new ArrayList<RewardItem>();
    public static List<RewardItem> kitchenItems = new ArrayList<RewardItem>();
    public static List<RewardItem> laundryItems = new ArrayList<RewardItem>();
    public static List<RewardItem> funItems = new ArrayList<RewardItem>();
    public static List<RewardItem> otherItems = new ArrayList<RewardItem>();
    public static Integer balance = new Integer(130);
    public static Integer subtotal = new Integer(0);
    public static Integer point_used = new Integer(0);
    public static Integer shipping = new Integer(30);
    public static Integer total = new Integer(0);
    public static List<CartItem> cartItems = new ArrayList<CartItem>();

    public static Map<String, RewardItem> itemMap = new HashMap<String, RewardItem>();

    public static RewardItem buffer;

    static {
        String desc = "The primary avenue for government assistance was the Rural Adjustment Scheme (RAS, previously termed the Farmers’ Debt Adjustment scheme and also the Rural Reconstruction schemes) and the Farm Household Support Scheme (FHSS). The RAS adopted structural adjustment initiatives to improve farm productivity, profitability and sustainability. These initiatives included interest rate subsidies, commercial borrowings, and small grants, all of which were subject to substantial increases under a provision of EC. The FHSS, however, was aimed at encouraging unviable farmers to exit the industry (Botterill and Wilhite, 2005). Together, the policy framework was viewed as a holistic response to recurrent drought events.";


        RewardItem item1 = new RewardItem("10001", "Bosch Front Load", Category.LAUNDRY, new Double(700), ItemType.WASHING_MACHINE, new Double(150), "wash " + desc, R.mipmap.wash);
        RewardItem item2 = new RewardItem("10002", "Village Movie Voucher", Category.FUN, new Double(100), ItemType.MOVIE_TICKET, new Double(30), "movie " + desc, R.mipmap.cinema);
        RewardItem item3 = new RewardItem("10003", "2.5KL Slimline Tank", Category.GARDEN, new Double(1650), ItemType.TANK, new Double(500), "tank " + desc, R.mipmap.tank);
        RewardItem item4 = new RewardItem("10004", "Bosch showerhead", Category.BATHROOM, new Double(100), ItemType.SHOWER_HEAD, new Double(50), "shower " + desc, R.mipmap.shower);
        RewardItem item5 = new RewardItem("10005", "Simmens Taps", Category.KITCHEN, new Double(80), ItemType.TAP, new Double(20), "tap " + desc, R.mipmap.taps);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);

        for (RewardItem item : items) {
            itemMap.put(item.getId(), item);
            switch(item.getCategory()) {
                case BATHROOM:
                    bathItems.add(item);
                    break;
                case GARDEN:
                    gardenItems.add(item);
                    break;
                case LAUNDRY:
                    laundryItems.add(item);
                    break;
                case KITCHEN:
                    kitchenItems.add(item);
                    break;
                case FUN:
                    funItems.add(item);
                    break;
                case OTHER:
                    otherItems.add(item);
                    break;

            }
        }


        CartItem cartItem1 = new CartItem(item1.getName(), new Double(item1.getPrice()-item1.getMaxDiscount()), item1.getImageResource(), toInt(item1.getMaxDiscount()));
        CartItem cartItem2 = new CartItem(item2.getName(), new Double(item2.getPrice()-item2.getMaxDiscount()), item2.getImageResource(), toInt(item2.getMaxDiscount()));
        CartItem cartItem3 = new CartItem(item3.getName(), new Double(item3.getPrice()-item3.getMaxDiscount()), item3.getImageResource(), toInt(item3.getMaxDiscount()));
        CartItem cartItem4 = new CartItem(item4.getName(), new Double(item4.getPrice()-item4.getMaxDiscount()), item4.getImageResource(), toInt(item4.getMaxDiscount()));
        /*cartItems.add(cartItem1);
        cartItems.add(cartItem2);
        cartItems.add(cartItem3);
        cartItems.add(cartItem4);*/

    }

    public static int toInt(Double d) {
        return (int) Math.round(d);
    }



}
