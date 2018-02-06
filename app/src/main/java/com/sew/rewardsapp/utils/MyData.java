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
    public static Integer balance = new Integer(673);
    public static Integer subtotal = new Integer(0);
    public static Integer pointUsed = new Integer(0);
    public static Integer shipping = new Integer(30);
    public static Integer total = new Integer(0);
    public static Integer redeemedPoints = new Integer(0);
    public static Integer waterSaved = new Integer(0);
    public static List<CartItem> cartItems = new ArrayList<CartItem>();

    public static Map<String, RewardItem> itemMap = new HashMap<String, RewardItem>();

    public static RewardItem buffer;

    static {
        String desc = "The primary avenue for government assistance was the Rural Adjustment Scheme (RAS, previously termed the Farmers’ Debt Adjustment scheme and also the Rural Reconstruction schemes) and the Farm Household Support Scheme (FHSS). The RAS adopted structural adjustment initiatives to improve farm productivity, profitability and sustainability. These initiatives included interest rate subsidies, commercial borrowings, and small grants, all of which were subject to substantial increases under a provision of EC. The FHSS, however, was aimed at encouraging unviable farmers to exit the industry (Botterill and Wilhite, 2005). Together, the policy framework was viewed as a holistic response to recurrent drought events.";


        RewardItem item1 = new RewardItem("10001", "Bosch Front Load", Category.LAUNDRY, new Double(1000), ItemType.WASHING_MACHINE, new Double(150), "wash " + desc, R.mipmap.bosch_front_load);
        RewardItem item2 = new RewardItem("10002", "Village Movie Voucher", Category.FUN, new Double(20), ItemType.MOVIE_TICKET, new Double(20), "movie " + desc, R.mipmap.village);
        RewardItem item3 = new RewardItem("10003", "2.5KL Slimline Tank", Category.GARDEN, new Double(2000), ItemType.TANK, new Double(350), "tank " + desc, R.mipmap.slim_tank);
        RewardItem item4 = new RewardItem("10004", "Bosch showerhead", Category.BATHROOM, new Double(100), ItemType.SHOWER_HEAD, new Double(20), "shower " + desc, R.mipmap.bosch_shower);
        RewardItem item5 = new RewardItem("10005", "Simmens Taps", Category.KITCHEN, new Double(90), ItemType.TAP, new Double(20), "sim tap " + desc, R.mipmap.simmens_taps);
        RewardItem item6 = new RewardItem("10006", "Bosch Dishwasher", Category.KITCHEN, new Double(600), ItemType.DISH_WASHER, new Double(50), "bosch dish " + desc, R.mipmap.bosch_dish);
        RewardItem item7 = new RewardItem("10007", "Fishers Fridge", Category.KITCHEN, new Double(900), ItemType.FRIDGE, new Double(130), "fridge " + desc, R.mipmap.fishers_fridge);
        RewardItem item8 = new RewardItem("10008", "Simmens Rain Showerhead", Category.BATHROOM, new Double(60), ItemType.SHOWER_HEAD, new Double(20), "sim rain shower " + desc, R.mipmap.simmens_rain_shower);
        RewardItem item9 = new RewardItem("10009", "LG AG Unit", Category.OTHER, new Double(600), ItemType.AC, new Double(470), "ac " + desc, R.mipmap.lg_ac);
        RewardItem item10 = new RewardItem("10010", "Bunnings Gift Card", Category.OTHER, new Double(50), ItemType.OTHER_VOUCHER, new Double(25), "bun " + desc, R.mipmap.bunnings);
        RewardItem item11 = new RewardItem("10011", "LG Filter Kitchen Tap", Category.KITCHEN, new Double(100), ItemType.TAP, new Double(50), "lg tap " + desc, R.mipmap.lg_tap);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);
        items.add(item11);

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

    }

    public static int toInt(Double d) {
        return (int) Math.round(d);
    }



}
